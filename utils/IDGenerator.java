package utils;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public final class IDGenerator {
    private static int currentFileIDInUse = 0;
    private static int currentCommitIDInUse = 1;

    private IDGenerator() {
    }

    public static int generateFileID() {
        IDGenerator.currentFileIDInUse += 2;
        return IDGenerator.currentFileIDInUse;
    }

    public static int generateCommitID() {
        IDGenerator.currentCommitIDInUse += 2;
        return IDGenerator.currentCommitIDInUse;
    }
}
