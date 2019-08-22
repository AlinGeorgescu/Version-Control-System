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
public final class CdOperation extends FileSystemOperation {
    public CdOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        FileSystemEntity newDirectory;

        if (this.operationArgs.size() == 1) {
            newDirectory = fileSystemSnapshot.getEntity(this.operationArgs.get(0));
            if (newDirectory == null) {
                return ErrorCodeManager.SYS_BAD_PATH_CODE;
            }
            if (newDirectory.getType().equals(EntityType.DIRECTORY)) {
                fileSystemSnapshot.setCurrentDir((Directory) newDirectory);
                return ErrorCodeManager.OK;
            }
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }

        return ErrorCodeManager.SYS_BAD_PATH_CODE;
    }
}
