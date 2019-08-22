package utils;

import vcs.Vcs;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public interface IAbstractOperation {
    ArrayList<String> getOperationArgs();

    OperationType getType();

    int accept(Vcs vcs);
}
