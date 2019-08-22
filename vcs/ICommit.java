package vcs;

import filesystem.FileSystemSnapshot;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public interface ICommit {
    int getId();

    String getMessage();

    FileSystemSnapshot getSnapshot();
}
