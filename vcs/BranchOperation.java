package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class BranchOperation extends VcsOperation {
    public BranchOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        if (vcs.getBranchIndex(operationArgs.get(0)) != -1) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        }

        vcs.createBranch(operationArgs.get(0), vcs.getCurrentBranch().getCommits());

        return ErrorCodeManager.OK;
    }
}
