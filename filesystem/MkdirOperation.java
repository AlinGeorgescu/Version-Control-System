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
public final class MkdirOperation extends FileSystemOperation {
    public MkdirOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        int result = ErrorCodeManager.OK;

        if (operationArgs == null) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }

        result = fileSystemSnapshot
                .addEntity(EntityType.DIRECTORY, operationArgs.get(0), operationArgs.get(1));

        return result;
    }
}
