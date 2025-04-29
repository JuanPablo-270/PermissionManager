package com.sintergica.ai.permissionmanager.v3.p1;

import java.util.EnumSet;

public enum Scope {
    SYSTEM (1 << 0, "System"),
    COMPANY (1 << 1, "Company"),
    GROUP (1 << 2, "Group"),
    MODEL (1 << 3, "Model"),
    KNOWLEDGE_BASE (1 << 4, "Knowledge Base"),
    MEMBERS (1 << 5, "Members"),
    USER (1 << 6, "User");

    private final int id;
    private final String name;
    public static final EnumSet<Scope> ALL_SCOPES = EnumSet.allOf(Scope.class);

    Scope(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}