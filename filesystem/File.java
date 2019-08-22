package filesystem;

import utils.EntityType;
import utils.IDGenerator;
import utils.OutputWriter;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public final class File extends FileSystemEntity {
    private String content;

    File(final String name, final Directory parent) {
        this.id = IDGenerator.generateFileID();
        this.type = EntityType.FILE;
        this.parent = parent;
        this.name = name;
        this.content = "";
    }

    @Override
    public FileSystemEntity getEntity(final String path) {
        return null;
    }

    @Override
    protected FileSystemEntity clone(final Directory newParent) {
        File newFile = new File(this.name, newParent);

        newFile.addContent(this.content);

        return newFile;
    }

    public void print(final String tabs, final OutputWriter outputWriter) {
        outputWriter.write(tabs + this.name + "\n");
    }

    public boolean hasEntity(final String name) {
        return false;
    }

    String getContent() {
        return this.content;
    }

    void addContent(final String s) {
        this.content += s;
    }
}
