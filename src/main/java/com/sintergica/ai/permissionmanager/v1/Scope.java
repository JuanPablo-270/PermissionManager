package com.sintergica.ai.permissionmanager.v1;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Scope {
    MODEL(1, "Model", "Scope for model permissions"),
    USER(2, "User", "Scope for user permissions"),
    GROUP(3, "Group", "Scope for group permissions"),
    SYSTEM(4, "System", "Scope for system permissions"),
    KNOWLEDGE(5, "Knowledge", "Scope for knowledge permissions"),
    MEMBERS(6, "Member", "Scope for member permissions");

    private final int id;
    private final String name;
    private final String description;
    private static final EnumSet<Scope> ALL_SCOPES = EnumSet.allOf(Scope.class);

    Scope(int id, String name, String description) {
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
    public static Scope fromId(int id) {
        for (Scope scope : Scope.values()) {
            if (scope.getId() == id) {
                return scope;
            }
        }
        throw new IllegalArgumentException("No scope found with id: " + id);
    }
    public static Scope fromName(String name) {
        for (Scope scope : Scope.values()) {
            if (scope.getName().equalsIgnoreCase(name)) {
                return scope;
            }
        }
        throw new IllegalArgumentException("No scope found with name: " + name);
    }
}