package utils;

import filesystem.CatOperation;
import filesystem.CdOperation;
import filesystem.LsOperation;
import filesystem.MkdirOperation;
import filesystem.RemoveOperation;
import filesystem.TouchOperation;
import filesystem.WriteToFileOperation;
import filesystem.PrintOperation;
import filesystem.InvalidFileSystemOperation;
import vcs.BranchOperation;
import vcs.CheckoutOperation;
import vcs.CommitOperation;
import vcs.InvalidVcsOperation;
import vcs.LogOperation;
import vcs.RollbackOperation;
import vcs.StatusOperation;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
final class OperationFactory {
    private static OperationFactory instance = null;

    private OperationFactory() {
    }

    static OperationFactory getInstance() {
        if (instance == null) {
            instance = new OperationFactory();
        }

        return instance;
    }

    AbstractOperation createOperation(final OperationType type, final ArrayList<String> args) {
        switch (type) {
            case CAT:
                return new CatOperation(type, args);
            case CHANGEDIR:
                return new CdOperation(type, args);
            case LIST:
                return new LsOperation(type, args);
            case MAKEDIR:
                return new MkdirOperation(type, args);
            case REMOVE:
                return new RemoveOperation(type, args);
            case TOUCH:
                return new TouchOperation(type, args);
            case WRITETOFILE:
                return new WriteToFileOperation(type, args);
            case PRINT:
                return new PrintOperation(type, args);
            case FILESYSTEM_INVALID_OPERATION:
                return new InvalidFileSystemOperation(type, args);

            case STATUS:
                return new StatusOperation(type, args);
            case BRANCH:
                return new BranchOperation(type, args);
            case COMMIT:
                return new CommitOperation(type, args);
            case CHECKOUT:
                return new CheckoutOperation(type, args);
            case LOG:
                return new LogOperation(type, args);
            case ROLLBACK:
                return new RollbackOperation(type, args);
            case VCS_INVALID_OPERATION:
                return new InvalidVcsOperation(type, args);

            default:
                return null;
        }
    }
}
