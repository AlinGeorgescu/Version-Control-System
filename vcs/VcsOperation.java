package vcs;

import utils.AbstractOperation;
import utils.OperationType;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public abstract class VcsOperation extends AbstractOperation {
    VcsOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    public abstract int execute(Vcs vcs);

    @Override
    public final int accept(final Vcs vcs) {
        return vcs.visit(this);
    }
}
