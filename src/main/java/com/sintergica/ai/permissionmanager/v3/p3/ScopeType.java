package com.sintergica.ai.permissionmanager.v3.p3;

import com.sintergica.ai.permissionmanager.v3.p1.Scope;

import java.util.EnumSet;

public enum ScopeType {
    SYSTEM (1 << 0, "System"),
    COMPANIES (1 << 1, "Company"),
    GROUPS (1 << 2, "Group"),
    MODELS (1 << 3, "Model"),
    KNOWLEDGE_BASES (1 << 4, "Knowledge Base"),
    MEMBERS (1 << 5, "Members"),
    USERS (1 << 6, "User");

    private final int id;
    private final String name;
    public static final EnumSet<Scope> ALL_SCOPES = EnumSet.allOf(Scope.class);

    ScopeType(int id, String name) {
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
