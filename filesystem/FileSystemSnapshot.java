package filesystem;

import utils.EntityType;
import utils.ErrorCodeManager;
import utils.OutputWriter;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public final class FileSystemSnapshot {
    private final Directory root;
    private final OutputWriter outputWriter;
    private Directory currentDir;

    private FileSystemSnapshot(final Directory root, final OutputWriter outputWriter) {
        this.root = root;
        currentDir = root;
        this.outputWriter = outputWriter;
    }

    public FileSystemSnapshot(final OutputWriter outputWriter) {
        root = new Directory("root", null);
        currentDir = root;
        this.outputWriter = outputWriter;
    }

    public FileSystemSnapshot cloneFileSystem() {
        return new FileSystemSnapshot((Directory) this.root.clone(null), this.outputWriter);
    }

    Directory getRoot() {
        return root;
    }

    OutputWriter getOutputWriter() {
        return outputWriter;
    }

    Directory getCurrentDir() {
        return currentDir;
    }

    void setCurrentDir(final Directory newDir) {
        this.currentDir = newDir;
    }

    public boolean hasEntity(String path) {
        if (!path.startsWith("/")) {
            path = currentDir.getPathToHere() + path;
        }
        path = path.replaceFirst("/", "");

        return this.root.hasEntity(path);
    }

    int addEntity(final EntityType type, final String path, final String name) {
        FileSystemEntity e;

        e = this.getEntity(path);
        if (e == null) {
            return ErrorCodeManager.SYS_BAD_PATH_CODE;
        }

        if (e.getType().equals(EntityType.DIRECTORY)) {
            FileSystemEntity newFse;
            Directory dir = (Directory) e;

            if (dir.hasEntity(name)) {
                return ErrorCodeManager.SYS_BAD_CMD_CODE;
            }

            switch (type) {
                case FILE:
                    newFse = new File(name, dir);
                    break;
                case DIRECTORY:
                    newFse = new Directory(name, dir);
                    break;
                default:
                    return ErrorCodeManager.SYS_BAD_PATH_CODE;
            }
            dir.addEntity(newFse);

            return ErrorCodeManager.OK;
        }

        return ErrorCodeManager.SYS_BAD_PATH_CODE;
    }

    FileSystemEntity getEntity(String path) {
        FileSystemEntity target;

        if (!path.startsWith("/")) {
            path = currentDir.getPathToHere() + path;
        }
        path = path.replaceFirst("/", "");
        target = this.root.getEntity(path);

        return target;
    }
}
