package com.sintergica.ai.permissionmanager.v4;

import java.util.List;
import java.util.UUID;

import com.sintergica.ai.permissionmanager.v3.p1.Permission;

public class ResourceAccessManager {
    public boolean canAccess(UUID resourceId, Permission permission, List<PermissionEntity> groupsAndUsers) {
        for (PermissionEntity entity : groupsAndUsers) {
            if (entity.hasPermission(resourceId, permission)) {
                return true;
            }
        }
        return false;
    }
}