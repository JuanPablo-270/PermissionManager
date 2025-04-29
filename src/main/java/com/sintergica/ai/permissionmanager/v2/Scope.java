package com.sintergica.ai.permissionmanager.v2;

import java.util.EnumSet;

public enum Scope {
    SYSTEM (1, "System", "Scope for system permissions"),
    COMPANY (2, "Company", "Scope for company permissions"),
    GROUP (3, "Group", "Scope for group permissions"),
    MODEL (4, "Model", "Scope for model permissions"),
    KNOWLEDGE_BASE (5, "Knowledge Base", "Scope for knowledge base permissions"),
    MEMBERS (6, "Members", "Scope for members permissions"),
    USER (7, "User", "Scope for user permissions");

    private final int id;
    private final String name;
    private final String description;
    public static final EnumSet<Scope> ALL_SCOPES = EnumSet.allOf(Scope.class);

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