package filesystem;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public final class PrintOperation extends FileSystemOperation {
    public PrintOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        fileSystemSnapshot.getRoot().print("", fileSystemSnapshot.getOutputWriter());

        return ErrorCodeManager.OK;
    }
}
