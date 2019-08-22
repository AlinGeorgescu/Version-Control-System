package utils;

/**
 * @project Version Control System
 * @author  Alin-Andrei Georgescu
 * (C)Copyright 2018
 */
public abstract class AbstractEntity {
    protected int id;
    protected EntityType type;

    public int getId() {
        return this.id;
    }

    public EntityType getType() {
        return this.type;
    }

    public abstract boolean hasEntity(String entityPath);
}
