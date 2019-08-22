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
public final class LsOperation extends FileSystemOperation {
    public LsOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final FileSystemSnapshot fileSystemSnapshot) {
        Directory dir;
        FileSystemEntity e;

        if (operationArgs.size() == 0) {
            e = fileSystemSnapshot.getCurrentDir();
        } else {
            e = fileSystemSnapshot.getEntity(operationArgs.get(0));
        }

        if (e == null) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }
        if (!e.getType().equals(EntityType.DIRECTORY)) {
            return ErrorCodeManager.SYS_BAD_CMD_CODE;
        }

        dir = (Directory) e;
        for (FileSystemEntity fse : dir.getContent()) {
            fileSystemSnapshot.getOutputWriter().write(fse.getName() + "\n");
        }

        return ErrorCodeManager.OK;
    }
}
