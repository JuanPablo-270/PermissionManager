package com.sintergica.ai.permissionmanager.v5;

import java.util.UUID;

import com.sintergica.ai.permissionmanager.v5.entities.Entity;

/**
 * AccessManager is a singleton class that manages access control for entities.
 * It provides methods to grant and revoke access permissions for users or groups
 * to specific entities, as well as to check if a user has access to an entity.
 * 
 * @author Panther
 */
public class AccessManager {

    private static AccessManager instance = null;
    private final AccessControlEntry accessControlEntry;

    /**
     * Private constructor for singleton pattern.
     * This constructor is private to prevent instantiation from outside the class
     * It initializes the AccessControlEntry instance.
     * The AccessControlEntry instance is used to manage permissions for entities.
     * 
     * @author Panther
     */
    private AccessManager() {
        this.accessControlEntry = AccessControlEntry.getEntry();
    }

    /**
     * Singleton instance of AccessManager.
     *
     * @author Panther
     * @return The singleton instance of AccessManager.
     */
    public static AccessManager manager() {
        if (instance == null) {
            instance = new AccessManager();
        }
        return instance;
    }

    /**
     * Tells the AccessManager to manage a specific entity.
     *
     * @author Panther
     * @param entity The entity to manage.
     */
    private void manage(Entity entity) {
        instance.accessControlEntry.setPermissions(entity.getPermissions());
    }

    /**
     * Grants access to a user or group for a specific entity and permission.
     *
     * @author Panther
     * @param entityID The ID of the user or group.
     * @param entity The agent, group, model, etc. to which access is being
     * granted.
     * @param permission The permission being granted.
     */
    public void grantAccess(UUID entityID, Entity entity, Permission permission) {
        instance.manage(entity);
        accessControlEntry.grantPermission(entityID, permission);
        entity.setPermissions(accessControlEntry.getPermissions());
    }

    /**
     * Revokes access from a user or group for a specific entity and permission.
     *
     * @author Panther
     * @param entityID The ID of the user or group.
     * @param entity The agent, group, model, etc. from which access is being
     * revoked.
     * @param permission The permission being revoked.
     */
    public void revokeAccess(UUID entityID, Entity entity, Permission permission) {
        instance.manage(entity);
        accessControlEntry.removePermission(entityID, permission);
        entity.setPermissions(accessControlEntry.getPermissions());
    }

    /**
     * Checks if a user has access to a agent, group, model, etc. for a specific
     * permission.
     *
     * @author Panther
     * @param entityID The ID of the user or group.
     * @param entity The agent, group, model, etc. to check access for.
     * @param permission The permission to check.
     * @return True if the {@code user} has access, {@code false} otherwise.
     */
    public boolean userCanAccess(UUID entityID, Entity entity, Permission permission) {
        instance.manage(entity);
        return accessControlEntry.hasPermission(entityID, permission);
    }
}
