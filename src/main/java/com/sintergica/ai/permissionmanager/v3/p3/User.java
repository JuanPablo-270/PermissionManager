package com.sintergica.ai.permissionmanager.v3.p3;

import com.sintergica.ai.permissionmanager.v3.p1.Permission;

import java.util.HashMap;
import java.util.UUID;

public class User {
    private String name;
    private int permissions;

    public User(String name) {
        this.name = name;
        this.permissions = 0; // No permissions by default
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        this.permissions |= permission.valor;
    }

    public void removePermission(Permission permission) {
        this.permissions &= ~permission.valor;
    }

    public boolean hasPermission(Permission permission) {
        return (this.permissions & permission.valor) == permission.valor;
    }

    public String getPermissionsAsString() {
        StringBuilder sb = new StringBuilder();
        for (Permission permission : Permission.values()) {
            if (hasPermission(permission)) {
                sb.append(permission.name()).append(" ");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(name).append(", Permissions: ");
        for (Permission permission : Permission.values()) {
            if (hasPermission(permission)) {
                sb.append(permission.name()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}