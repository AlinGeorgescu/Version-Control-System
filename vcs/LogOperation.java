package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;
import java.util.List;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public class LogOperation extends VcsOperation {
    public LogOperation(final OperationType type, final ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    @Override
    public int execute(final Vcs vcs) {
        List<Commit> commits = vcs.getCurrentBranch().getCommits();

        for (Commit c : commits) {
            vcs.getOutputWriter().write("Commit id: " + c.getId()
                    + "\nMessage: " + c.getMessage() +  "\n");

            if (c != commits.get(commits.size() - 1)) {
                vcs.getOutputWriter().write("\n");
            }
        }

        return ErrorCodeManager.OK;
    }
}
