package vcs;

import java.util.List;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public interface IBranch {
    String getName();

    List<Commit> getCommits();

    Commit getLastCommit();

    void addCommit(Commit c);

    void deleteCommits(int index);
}
