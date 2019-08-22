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
public final class WriteToFileOperation extends FileSystemOperation {
    public WriteToFileOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        File file;

        if (operationArgs.size() != 2) {
            return ErrorCodeManager.SYS_BAD_CMD_CODE;
        }

        FileSystemEntity fileSystemEntity = fileSystemSnapshot.getEntity(operationArgs.get(0));
        if (fileSystemEntity == null || !fileSystemEntity.getType().equals(EntityType.FILE)) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }

        file = (File) fileSystemEntity;
        file.addContent(operationArgs.get(1));

        return ErrorCodeManager.OK;
    }
}
