package filesystem;

import utils.AbstractOperation;
import utils.OperationType;
import vcs.Vcs;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public abstract class FileSystemOperation extends AbstractOperation {
    FileSystemOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    public abstract int execute(FileSystemSnapshot fileSystemSnapshot);

    @Override
    public final int accept(final Vcs vcs) {
        return vcs.visit(this);
    }
}
