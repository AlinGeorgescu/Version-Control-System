package vcs;

import filesystem.FileSystemSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
class Branch implements IBranch {
    private final String name;
    private List<Commit> commits;

    Branch(final FileSystemSnapshot activeSnapshot) {
        name = "master";
        commits = new ArrayList<>();
        commits.add(new Commit("First commit", activeSnapshot));
    }

    Branch(final String name, final List<Commit> commits) {
        this.name = name;
        this.commits = commits;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Commit> getCommits() {
        return commits;
    }

    @Override
    public Commit getLastCommit() {
        return commits.get(commits.size() - 1);
    }

    @Override
    public void addCommit(final Commit c) {
        commits.add(c);
    }

    @Override
    public void deleteCommits(final int index) {
        commits = commits.subList(0, index + 1);
    }
}
