package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;
import java.util.List;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class CheckoutOperation extends VcsOperation {
    public CheckoutOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        List<String> arguments = getOperationArgs();

        if (!vcs.getStagedChanges().isEmpty()) {
            return ErrorCodeManager.VCS_STAGED_OP_CODE;
        }

        if (!arguments.get(0).equals("-c")) {
            String branch = arguments.get(0);
            int index = vcs.getBranchIndex(branch);

            if (index == -1) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }

            vcs.setHead(index);
            vcs.setNewActiveSnapshot(vcs.getCurrentBranch().getLastCommit().getSnapshot());
        } else {
            int id = Integer.valueOf(getOperationArgs().get(1));
            int index = vcs.getCommitIndex(id);

            if (index == -1) {
                return ErrorCodeManager.VCS_BAD_PATH_CODE;
            }

            vcs.deleteCommits(index);
            vcs.setNewActiveSnapshot(vcs.getCurrentBranch().getLastCommit().getSnapshot());
        }

        return ErrorCodeManager.OK;
    }
}

