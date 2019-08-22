package filesystem;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public final class InvalidFileSystemOperation extends FileSystemOperation {
    public InvalidFileSystemOperation(final OperationType type,
                                      final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        return ErrorCodeManager.SYS_BAD_CMD_CODE;
    }
}
