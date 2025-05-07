package com.sintergica.ai.permissionmanager.v5;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class AccessControlEntry {
    private static AccessControlEntry instance = null;
    private final Map<UUID, Integer> permissions = new java.util.HashMap<>();

    private AccessControlEntry() {
    }

    public static AccessControlEntry getEntry() {
        if (instance == null) {
            instance = new AccessControlEntry();
        }
        return instance;
    }

    public void setPermissions(Map<UUID, Integer> permissions) {
        this.permissions.clear();
        this.permissions.putAll(permissions);
    }

    public Map<UUID, Integer> getPermissions() {
        return this.permissions;
    }

    public void grantPermission(UUID entityId, Permission permission) {
        permissions.put(entityId, permissions.getOrDefault(entityId, 0) | permission.BIT_REPRESENTATION);
    }

    public void removePermission(UUID entityId, Permission permission) {
        int currentPermissions = permissions.getOrDefault(entityId, 0);
        permissions.put(entityId, currentPermissions & ~permission.BIT_REPRESENTATION);
    }

    public boolean hasPermission(UUID entityId, Permission permission) {
        return (permissions.getOrDefault(entityId, 0) & permission.BIT_REPRESENTATION) == permission.BIT_REPRESENTATION;
    }

    public Set<UUID> canAccessUuids(){
        return permissions.keySet();
    }
}