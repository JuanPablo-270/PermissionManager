package com.sintergica.ai.permissionmanager.v5;
import java.util.UUID;

import com.sintergica.ai.permissionmanager.v5.entities.Entity;

public class AccessManager {
    private static AccessManager instance = null;
    private final AccessControlEntry accessControlEntry;
    //private Entity entity;

    private AccessManager() {
        this.accessControlEntry = AccessControlEntry.getEntry();
    }

    /**
     * Singleton instance of AccessManager.
     * @return The singleton instance of AccessManager.
     */
    public static AccessManager manager(){
        if(instance == null){
            instance = new AccessManager();
        }
        return instance;
    }

    /**
     * Tells the AccessManager to manage a specific entity.
     * @param entity The entity to manage.
     */
    public void manage(Entity entity){
        instance.accessControlEntry.setPermissions(entity.getPermissions());
        //instance.entity = entity;
    }

    /**
     * Grants access to a user or group for a specific entity and permission.
     * @param entityID The ID of the user or group.
     * @param entity The agent, group, model, etc. to which access is being granted.
     * @param permission The permission being granted.
     */
    public void grantAccess(UUID entityID, Entity entity, Permission permission){
        instance.manage(entity);
        accessControlEntry.grantPermission(entityID, permission);
        entity.setPermissions(accessControlEntry.getPermissions());
    }

    /**
     * Revokes access from a user or group for a specific entity and permission.
     * @param entityID The ID of the user or group.
     * @param entity The agent, group, model, etc. from which access is being revoked.
     * @param permission The permission being revoked.
     */
    public void revokeAccess(UUID entityID, Entity entity, Permission permission){
        instance.manage(entity);
        accessControlEntry.removePermission(entityID, permission);
        entity.setPermissions(accessControlEntry.getPermissions());
    }

    /**
     * Checks if a user has access to a model based on the provided AccessControlEntry and permission.
     */
    public boolean userCanAccess(
        UUID entityID,
        Entity entity,
        Permission permission
    ){
        instance.manage(entity);
        if (accessControlEntry.hasPermission(entityID, permission)) {
            return true;
        } else {
            System.out.println("User " + entityID + " does not have " + permission + " permission on model " + entity.getName());
        }
        return false;
    }
}
