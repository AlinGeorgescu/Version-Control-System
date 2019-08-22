package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class InvalidVcsOperation extends VcsOperation {
    public InvalidVcsOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        return ErrorCodeManager.VCS_BAD_CMD_CODE;
    }
}
