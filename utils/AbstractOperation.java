package utils;

import vcs.Vcs;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public abstract class AbstractOperation implements IAbstractOperation {
    private final OperationType type;
    protected final ArrayList<String> operationArgs;

    protected AbstractOperation(final OperationType type, final ArrayList<String> operationArgs) {
        this.type = type;
        this.operationArgs = operationArgs;
    }

    @Override
    public ArrayList<String> getOperationArgs() {
        return this.operationArgs;
    }

    @Override
    public OperationType getType() {
        return this.type;
    }

    @Override
    public abstract int accept(Vcs vcs);
}
