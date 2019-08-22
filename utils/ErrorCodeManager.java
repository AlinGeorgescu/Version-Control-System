package utils;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public final class ErrorCodeManager {
    private static final String SYS_BAD_CMD_STR = "System: Bad command";
    private static final String SYS_BAD_PATH_STR = "System: Bad path";
    private static final String VCS_BAD_CMD_STR = "Vcs: Bad command";
    private static final String VCS_BAD_PATH_STR = "Vcs: Bad path";
    private static final String VCS_STAGED_OP_STR
            = "Vcs: There are staged operations, please do commit/rollback!";
    public static final int SYS_BAD_CMD_CODE = 1;
    public static final int SYS_BAD_PATH_CODE = 2;
    public static final int VCS_BAD_CMD_CODE = -1;
    public static final int VCS_BAD_PATH_CODE = -2;
    public static final int VCS_STAGED_OP_CODE = -3;
    public static final int OK = 0;

    private static ErrorCodeManager instance;

    private ErrorCodeManager() {
    }

    static ErrorCodeManager getInstance() {
        if (instance == null) {
            instance = new ErrorCodeManager();
        }

        return instance;
    }

    boolean checkExitCode(final OutputWriter writer, final int exitCode) {
        String err = "";

        switch (exitCode) {
            case 0:
                return false;
            case SYS_BAD_CMD_CODE:
                err = SYS_BAD_CMD_STR;
                break;
            case SYS_BAD_PATH_CODE:
                err = SYS_BAD_PATH_STR;
                break;
            case VCS_BAD_CMD_CODE:
                err = VCS_BAD_CMD_STR;
                break;
            case VCS_BAD_PATH_CODE:
                err = VCS_BAD_PATH_STR;
                break;
            case VCS_STAGED_OP_CODE:
                err = VCS_STAGED_OP_STR;
            default:
                break;
        }
        String message = exitCode + " : " + err + "\n";
        writer.write(message);

        return true;
    }
}
