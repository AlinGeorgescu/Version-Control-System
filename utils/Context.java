package utils;

import vcs.Vcs;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public final class Context {
    private Vcs vcs;
    private static Context instance = null;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    private Context() {
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }

        return instance;
    }

    public void init(final String input, final String output) {
        inputReader = new InputReader(input);
        outputWriter = new OutputWriter(output);
        vcs = new Vcs(outputWriter);
    }

    public void run() {
        String operationString;
        AbstractOperation operation;
        OperationParser parser = new OperationParser();
        int exitCode;
        boolean wasError;

        this.vcs.init();

        while (true) {
            operationString = this.inputReader.readLine();
            if (operationString == null || operationString.isEmpty()) {
                continue;
            }
            if (operationString.equals("exit")) {
                return;
            }

            operation = parser.parseOperation(operationString);
            exitCode = operation.accept(vcs);
            wasError = ErrorCodeManager.getInstance().checkExitCode(outputWriter, exitCode);

            if (!wasError && this.isTrackable(operation)) {
                vcs.addStagedOperation(operation);
            }
        }
    }

    private boolean isTrackable(final AbstractOperation abstractOperation) {
        boolean result;

        switch (abstractOperation.getType()) {
            case CHANGEDIR:
            case MAKEDIR:
            case REMOVE:
            case TOUCH:
            case WRITETOFILE:
                result = true;
                break;
            default:
                result = false;
        }

        return result;
    }
}
