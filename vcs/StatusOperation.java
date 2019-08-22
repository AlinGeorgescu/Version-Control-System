package vcs;

import utils.AbstractOperation;
import utils.ErrorCodeManager;
import utils.OperationType;
import utils.OutputWriter;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class StatusOperation extends VcsOperation {
    public StatusOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        OutputWriter out = vcs.getOutputWriter();
        out.write("On branch: " + vcs.getCurrentBranch().getName() + "\n");
        out.write("Staged changes:\n");

        for (AbstractOperation op : vcs.getStagedChanges()) {
            switch (op.getType()) {
                case CHANGEDIR:
                    out.write("\tChanged directory to " + op.getOperationArgs() + "\n");
                    break;
                case MAKEDIR:
                    out.write("\tCreated directory " + op.getOperationArgs() + "\n");
                    break;
                case REMOVE:
                    out.write("\tRemoved " + op.getOperationArgs() + "\n");
                    break;
                case TOUCH:
                    out.write("\tCreated file " + op.getOperationArgs().get(1) + "\n");
                    break;
                case WRITETOFILE:
                    out.write("\tAdded \"" + op.getOperationArgs().get(1) + "\" to file "
                            + op.getOperationArgs().get(0) + "\n");
                    break;
                default:
                    out.write("");
            }
        }

        return ErrorCodeManager.OK;
    }
}
