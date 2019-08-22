package vcs;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.AbstractOperation;
import utils.OutputWriter;
import utils.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private FileSystemSnapshot activeSnapshot;
    private List<AbstractOperation> staging;
    private List<Branch> branches;
    private int head;

    public Vcs(final OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void init() {
        this.activeSnapshot = new FileSystemSnapshot(outputWriter);
        staging = new ArrayList<>();
        branches = new ArrayList<>();
        branches.add(new Branch(activeSnapshot));
        head = 0;
    }

    public int visit(final FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    @Override
    public int visit(final VcsOperation vcsOperation) {
        return vcsOperation.execute(this);
    }

    public void addStagedOperation(final AbstractOperation operation) {
        staging.add(operation);
    }

    List<AbstractOperation> getStagedChanges() {
        return staging;
    }

    void clearStaging() {
        staging.clear();
    }

    Branch getCurrentBranch() {
        return branches.get(head);
    }

    int getBranchIndex(final String name) {
        int i = 0;
        for (Branch b : branches) {
            if (b.getName().equals(name)) {
                return i;
            }
            ++i;
        }

        return -1;
    }

    void createBranch(final String name, final List<Commit> commits) {
        branches.add(new Branch(name, commits));
    }

    void setHead(final int head) {
        this.head = head;
    }

    Commit getLastCommit() {
        return branches.get(head).getLastCommit();
    }

    int getCommitIndex(final int id) {
        int i = 0;
        for (Commit c : branches.get(head).getCommits()) {
            if (id  == c.getId()) {
                return i;
            }
            ++i;
        }

        return -1;
    }

    void deleteCommits(final int index) {
        branches.get(head).deleteCommits(index);
    }

    FileSystemSnapshot getActiveSnapshot() {
        return activeSnapshot;
    }

    void setNewActiveSnapshot(final FileSystemSnapshot snap) {
        activeSnapshot = snap;
    }

    OutputWriter getOutputWriter() {
        return outputWriter;
    }
}
