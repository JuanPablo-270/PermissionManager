package com.sintergica.ai.permissionmanager.v5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * AccessControlEntry is a singleton class that manages the access control entries for entities.
 * It provides methods to set, get, grant, remove, and check permissions for entities.
 * 
 * @author Panther
 */
public class AccessControlEntry {
    private static AccessControlEntry instance = null;
    private final Map<UUID, Integer> permissions;

    /**
     * Private constructor for singleton pattern.
     * This constructor is private to prevent instantiation from outside the class
     * It initializes the permissions map.
     * The permissions map is used to store the permissions for each entity.
     * 
     * @author Panther
     */
    private AccessControlEntry() {
        this.permissions = new HashMap<>();
    }

    /**
     * Singleton instance of AccessControlEntry.
     *
     * @author Panther
     * @return The singleton instance of AccessControlEntry.
     */
    public static AccessControlEntry getEntry() {
        if (instance == null) {
            instance = new AccessControlEntry();
        }
        return instance;
    }

    /**
     * Sets the permissions for the entity.
     *
     * @author Panther
     * @param permissions The permissions to set.
     */
    public void setPermissions(Map<UUID, Integer> permissions) {
        this.permissions.clear();
        this.permissions.putAll(permissions);
    }

    /**
     * Gets the permissions for the entity.
     * 
     * @author Panther
     * @return The permissions for the entity.
     */
    public Map<UUID, Integer> getPermissions() {
        return this.permissions;
    }

    /**
     * Grants a specific permission to an entity.
     *
     * @author Panther
     * @param entityId The ID of the entity to grant permission to.
     * @param permission The permission to grant.
     */
    public void grantPermission(UUID entityId, Permission permission) {
        permissions.put(entityId, permissions.getOrDefault(entityId, 0) | permission.BIT_REPRESENTATION);
    }

    /**
     * Revokes a specific permission from an entity.
     *
     * @author Panther
     * @param entityId The ID of the entity to revoke permission from.
     * @param permission The permission to revoke.
     */
    public void removePermission(UUID entityId, Permission permission) {
        int currentPermissions = permissions.getOrDefault(entityId, 0);
        int updatedPermissions = currentPermissions & ~permission.BIT_REPRESENTATION;
        if (updatedPermissions == 0) {
            permissions.remove(entityId);
        } else {
            permissions.put(entityId, updatedPermissions);
        }
    }

    /**
     * Checks if an entity has a specific permission.
     *
     * @author Panther
     * @param entityId The ID of the entity to check.
     * @param permission The permission to check.
     * @return True if the entity has the permission, false otherwise.
     */
    public boolean hasPermission(UUID entityId, Permission permission) {
        return (permissions.getOrDefault(entityId, 0) & permission.BIT_REPRESENTATION) == permission.BIT_REPRESENTATION;
    }

    /**
     * Returns a set of UUIDs that can access the entity.
     *
     * @author Panther
     * @return A set of UUIDs that can access the entity.
     */
    public Set<UUID> canAccessUuids(){
        return permissions.keySet();
    }
}