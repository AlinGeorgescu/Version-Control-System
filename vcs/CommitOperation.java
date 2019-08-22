package vcs;

import filesystem.FileSystemSnapshot;
import utils.AbstractOperation;
import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;
import java.util.List;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class CommitOperation extends VcsOperation {
    public CommitOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        List<AbstractOperation> staging = vcs.getStagedChanges();
        FileSystemSnapshot activeSnapshot = vcs.getActiveSnapshot();

        if (staging.size() == 0) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        }

        StringBuilder stringArgs = new StringBuilder();
        for (int i = 1; i < operationArgs.size(); ++i) {
            stringArgs.append(operationArgs.get(i));
            if (i != operationArgs.size() - 1) {
                stringArgs.append(" ");
            }
        }

        vcs.getCurrentBranch().addCommit(new Commit(stringArgs.toString(), activeSnapshot));
        vcs.clearStaging();

        return ErrorCodeManager.OK;
    }
}
