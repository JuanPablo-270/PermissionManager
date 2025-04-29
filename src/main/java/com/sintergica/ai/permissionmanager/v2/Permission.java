package com.sintergica.ai.permissionmanager.v2;

public enum Permission {
    READ("read"),
    WRITE("write"),
    EXECUTE("execute");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}