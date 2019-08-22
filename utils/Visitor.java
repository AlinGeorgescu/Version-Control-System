package utils;

import filesystem.FileSystemOperation;
import vcs.VcsOperation;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public interface Visitor {
    int visit(FileSystemOperation fileSystemOperation);

    int visit(VcsOperation vcsOperation);
}
