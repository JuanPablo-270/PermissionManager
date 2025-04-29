package com.sintergica.ai.permissionmanager.v1;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Perms {
    READ (1, "Read", "Permission to read content"),
    WRITE (2, "Write", "Permission to write content"),
    EXECUTE (3, "Execute", "Permission to execute content"),
    DELETE (4, "Delete", "Permission to delete content"),
    UPDATE (5, "Update", "Permission to update content");

    public static final EnumSet<Perms> ALL_PERMS = EnumSet.allOf(Perms.class);

    private final int id;
    private final String name;
    private final String description;

    Perms(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Perms fromId(int id) {
        for (Perms permission : Perms.values()) {
            if (permission.getId() == id) {
                return permission;
            }
        }
        throw new IllegalArgumentException("No permission found with id: " + id);
    }
    
    public static Perms fromName(String name) {
        for (Perms permission : Perms.values()) {
            if (permission.getName().equalsIgnoreCase(name)) {
                return permission;
            }
        }
        throw new IllegalArgumentException("No permission found with name: " + name);
    }
}