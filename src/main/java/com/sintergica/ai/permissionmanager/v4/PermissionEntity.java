package com.sintergica.ai.permissionmanager.v4;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.sintergica.ai.permissionmanager.v3.p1.Permission;

public class PermissionEntity {
    private String name;
    private UUID ID;
    private final Map<UUID, Integer> permissionsByResource = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public Map<UUID, Integer> getPermissionsByResource() {
        return permissionsByResource;
    }

    public void setPermission(UUID resourceId, Permission permission) {
        permissionsByResource.put(resourceId, permissionsByResource.getOrDefault(resourceId, 0) | permission.valor);
    }

    public void removePermission(UUID resourceId, Permission permission) {
        int currentPermissions = permissionsByResource.getOrDefault(resourceId, 0);
        // Usamos el bit NOT para borrar el permiso específico
        permissionsByResource.put(resourceId, currentPermissions & ~permission.valor);
    }

    public boolean hasPermission(UUID resourceId, Permission permission) {
        return (permissionsByResource.getOrDefault(resourceId, 0) & permission.valor) == permission.valor;
    }
}