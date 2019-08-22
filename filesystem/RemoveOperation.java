package filesystem;

import utils.EntityType;
import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public final class RemoveOperation extends FileSystemOperation {
    public RemoveOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        if (operationArgs.get(0).equals("rm")) {
            return rm(fileSystemSnapshot);
        } else if (operationArgs.get(0).equals("rmdir")) {
            return rmdir(fileSystemSnapshot, 1);
        }
        return ErrorCodeManager.SYS_BAD_PATH_CODE;
    }

    private int rm(final FileSystemSnapshot fileSystemSnapshot) {
        if (operationArgs.get(1).equals("-r")) {
            return rmdir(fileSystemSnapshot, 2);
        }

        String path = operationArgs.get(1);
        FileSystemEntity fse = fileSystemSnapshot.getEntity(path);

        if (fse == null) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }
        if (fse.getType().equals(EntityType.DIRECTORY)) {
            return ErrorCodeManager.SYS_BAD_CMD_CODE;
        }

        fse.parent.remove(fse.name);

        return ErrorCodeManager.OK;
    }

    private int rmdir(final FileSystemSnapshot fileSystemSnapshot, final int argPos) {
        Directory dir;
        String path = operationArgs.get(argPos);
        FileSystemEntity fse = fileSystemSnapshot.getEntity(path);

        if (fse == null) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }
        if (!fse.getType().equals(EntityType.DIRECTORY)) {
            return ErrorCodeManager.SYS_BAD_CMD_CODE;
        }

        dir = (Directory) fse;
        dir.parent.remove(fse.name);

        return ErrorCodeManager.OK;
    }
}
