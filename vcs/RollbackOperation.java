package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class RollbackOperation extends VcsOperation {
    public RollbackOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        vcs.setNewActiveSnapshot(vcs.getLastCommit().getSnapshot());

        return ErrorCodeManager.OK;
    }
}

