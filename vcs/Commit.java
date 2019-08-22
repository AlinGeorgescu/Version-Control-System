package vcs;

import filesystem.FileSystemSnapshot;
import utils.IDGenerator;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
class Commit implements ICommit {
    private final int id;
    private final String message;
    private final FileSystemSnapshot snapshot;

    Commit(final String message, final FileSystemSnapshot snapshot) {
        id = IDGenerator.generateCommitID();
        this.message = message;
        this.snapshot = snapshot.cloneFileSystem();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public FileSystemSnapshot getSnapshot() {
        return snapshot;
    }
}
