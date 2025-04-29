package com.sintergica.ai.permissionmanager.v3.p1;

import java.util.HashMap;

public class User {
    private String name;
    private int permissions;
    private final HashMap<Scope, Integer> permissionsMap;

    public User(String name) {
        this.name = name;
        this.permissions = 0; // No permissions by default
        this.permissionsMap = new HashMap<>();
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

    public HashMap<Scope, Integer> getPermissionsMap() {
        return permissionsMap;
    }

    public void setPermissionsMap(HashMap<Scope, Integer> permissionsMap) {
        this.permissionsMap.clear();
        this.permissionsMap.putAll(permissionsMap);
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

    public HashMap<Scope, String[]> getPermissionsByScope() {
        HashMap<Scope, String[]> permissionsByScope = new HashMap<>();
        for (Scope scope : Scope.values()) {
            if (permissionsMap.containsKey(scope)) {
                int permissionValue = permissionsMap.get(scope);
                String[] permissionsArray = new String[Permission.values().length];
                for (Permission permission : Permission.values()) {
                    if ((permissionValue & permission.valor) == permission.valor) {
                        permissionsArray[permission.ordinal()] = permission.name();
                    }
                }
                permissionsByScope.put(scope, permissionsArray);
            }
        }
        return permissionsByScope;
    }

    public String getPermissionsByScopeAsString() {
        StringBuilder sb = new StringBuilder();
        for (Scope scope : Scope.values()) {
            if (permissionsMap.containsKey(scope)) {
                sb.append(scope.name()).append(": ");
                int permissionValue = permissionsMap.get(scope);
                for (Permission permission : Permission.values()) {
                    if ((permissionValue & permission.valor) == permission.valor) {
                        sb.append(permission.name()).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }

    public void addPermission(Scope scope, Permission permissionValue) {
        if (permissionsMap.containsKey(scope)) {
            // If the scope already exists, update the permissions
            int permissionsTmp = permissionsMap.get(scope);
            permissionsTmp |= permissionValue.valor;
            permissionsMap.replace(scope, permissionsTmp);
        } else {
            // If the scope does not exist, add it to the map
            permissionsMap.put(scope, permissionValue.valor);
        }

        //permissionsMap.put(scope, permissionValue.valor);
        //this.permissions |= permissionValue.valor;
    }

    public void removePermission(Scope scope, Permission permissionValue) {
        // Remove the permission from the map and update the permissions
        if (permissionsMap.containsKey(scope)) {
            int permissionsTmp = permissionsMap.get(scope);
            permissionsTmp ^= permissionValue.valor;
            if (permissionsTmp == 0) {
                permissionsMap.remove(scope);
            } else {
                permissionsMap.replace(scope, permissionsTmp);
            }
        }
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