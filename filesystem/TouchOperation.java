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
public final class TouchOperation extends FileSystemOperation {
    public TouchOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        if (operationArgs.size() != 2) {
            return ErrorCodeManager.SYS_BAD_CMD_CODE;
        }

        return fileSystemSnapshot
                .addEntity(EntityType.FILE, operationArgs.get(0), operationArgs.get(1));
    }
}
