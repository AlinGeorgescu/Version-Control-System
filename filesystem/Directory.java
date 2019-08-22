package filesystem;

import utils.EntityType;
import utils.IDGenerator;
import utils.OutputWriter;

import java.util.ArrayList;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public final class Directory extends FileSystemEntity {
    private static final int PARENT = -1;
    private static final int THIS = 1;
    private static final int NOTHING = 0;
    private final String pathToHere;
    private final ArrayList<FileSystemEntity> childrenEntities;

    Directory(final String name, final Directory parent) {
        this.id = IDGenerator.generateFileID();
        this.type = EntityType.DIRECTORY;
        this.name = name;
        this.parent = parent;
        this.childrenEntities = new ArrayList<>();
        if (parent != null) {
            pathToHere = parent.getPathToHere();
        } else {
            pathToHere = "/";
        }
    }

    public void print(String tabs, final OutputWriter outputWriter) {
        outputWriter.write(tabs + this.name + "\n");
        tabs += "\t";
        for (FileSystemEntity e : childrenEntities) {
            e.print(tabs, outputWriter);
        }
    }

    void addEntity(final FileSystemEntity entity) {
        this.childrenEntities.add(entity);
    }

    ArrayList<FileSystemEntity> getContent() {
        return this.childrenEntities;
    }

    String getPathToHere() {
        return pathToHere + this.name + "/";
    }

    public boolean hasEntity(final String path) {
        String[] parts = path.split("/", 2);
        FileSystemEntity currentEntity = getEntity(parts);

        if (parts.length == 1) {
            return currentEntity != null;
        } else {
            if (currentEntity == null) {
                return false;
            }

            return currentEntity.hasEntity(parts[1]);
        }
    }

    public FileSystemEntity getEntity(final String path) {
        String[] parts = path.split("/", 2);
        FileSystemEntity currentEntity = getEntity(parts);

        if (currentEntity == null) {
            return null;
        }

        if (parts.length == 1 || parts[1].isEmpty()) {
            return currentEntity;
        } else {
            return currentEntity.getEntity(parts[1]);
        }
    }

    private FileSystemEntity getEntity(final String[] parts) {
        FileSystemEntity result = null;

        switch (checkForSpecialFolder(parts[0])) {
            case PARENT:
                result = this.parent;
                break;
            case THIS:
                result = this;
                break;
            case NOTHING:
                if (this.name.equals("root") && this.name.equals(parts[0])) {
                    result = this;
                } else {
                    for (FileSystemEntity fileSystemEntity : this.childrenEntities) {
                        if (fileSystemEntity.getName().equals(parts[0])) {
                            result = fileSystemEntity;
                            break;
                        }
                    }
                }
            default:
                break;
        }

        return result;
    }

    private int checkForSpecialFolder(final String currentPart) {
        if (currentPart.equals(".")) {
            return THIS;
        }
        if (currentPart.equals("..")) {
            return PARENT;
        }

        return NOTHING;
    }

    void remove(final String name) {
        for (int i = 0; i < this.childrenEntities.size(); i++) {
            if (childrenEntities.get(i).name.equals(name)) {
                this.childrenEntities.remove(i);
                break;
            }
        }
    }

    public FileSystemEntity clone(final Directory newParent) {
        Directory clonedDir = new Directory(this.name, newParent);

        for (FileSystemEntity fileSystemEntity : this.childrenEntities) {
            clonedDir.addEntity(fileSystemEntity.clone(this));
        }

        return clonedDir;
    }
}
