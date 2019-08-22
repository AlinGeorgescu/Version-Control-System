package filesystem;

import utils.AbstractEntity;
import utils.OutputWriter;

/**
 * @project Version Control System
 * @author  echipa POO
 * (C)Copyright 2018
 */
public abstract class FileSystemEntity extends AbstractEntity {
    protected String name;
    protected Directory parent;

    protected String getName() {
        return this.name;
    }

    protected abstract void print(String tabs, OutputWriter outputWriter);

    protected abstract FileSystemEntity getEntity(String path);

    protected abstract FileSystemEntity clone(Directory newParent);
}
