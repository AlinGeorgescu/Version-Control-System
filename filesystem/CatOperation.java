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
public final class CatOperation extends FileSystemOperation {
    public CatOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        File f;

        if (operationArgs.size() != 1) {
            return ErrorCodeManager.SYS_BAD_CMD_CODE;
        }

        FileSystemEntity fse = fileSystemSnapshot.getEntity(operationArgs.get(0));

        if (fse == null) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }
        if (!fse.getType().equals(EntityType.FILE)) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }

        f = (File) fse;
        fileSystemSnapshot.getOutputWriter().write(f.getContent() + "\n");

        return ErrorCodeManager.OK;
    }
}
