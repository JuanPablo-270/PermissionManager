package com.sintergica.ai.permissionmanager.v1;

import java.util.HashMap;
import java.util.Map;

public class User{
    private String name;
    private int age;
    private UserRole role;
    private HashMap<Integer,Permission> permissions;
    private HashMap<Permission,Scope[]> grants;
    
    public User() {
        this.name = "";
        this.age = 0;
        this.permissions = new HashMap<>();
        this.grants = new HashMap<>();
    }
    
    public User(String name, int age, UserRole role) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.permissions = new HashMap<>();
        this.grants = new HashMap<>();
    }

    public User(String name, int age, UserRole role, HashMap<Integer,Permission> permissions) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.permissions = permissions;
    }

    public User(String name, int age, UserRole role, HashMap<Integer,Permission> permissions, HashMap<Permission,Scope[]> grants) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.permissions = permissions;
        this.grants = grants;
    }

    public HashMap<Permission,Scope[]> getGrants() {
        return grants;
    }

    public void setGrants(HashMap<Permission,Scope[]> grants) {
        this.grants = grants;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void addPermission(Permission permission) {
        int permissionID = permission.getId();
        if (permissions.containsKey(permissionID)) {
            throw new IllegalArgumentException("Permission with ID " + permissionID + " already exists.");
        }
        permissions.put(permissionID, permission);
    }

    public void removePermission(int permissionID) {
        permissions.remove(permissionID);
    }

    public Permission getPermission(int permissionID) {
        return permissions.get(permissionID);
    }

    public HashMap<Integer,Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(HashMap<Integer
    ,Permission> permissions) {
        this.permissions = permissions;
    }

    public boolean addGrant(Permission permission, Scope[] scope) {
        if (permissions.containsKey(permission.getId())) {
            if (grants.containsKey(permission)) {
                Scope[] existingScopes = grants.get(permission);
                Scope[] newScopes = new Scope[existingScopes.length + scope.length];
                System.arraycopy(existingScopes, 0, newScopes, 0, existingScopes.length);
                System.arraycopy(scope, 0, newScopes, existingScopes.length, scope.length);
                grants.put(permission, newScopes);
            } else {
                grants.put(permission, scope);
            }
            return true;
        } else {
            throw new IllegalArgumentException("Permission with ID " + permission.getId() + " does not exist.");
        }
    }
    
    public void removeGrant(Permission permission) {
        grants.remove(permission);
    }
    
    public Scope[] getGrant(Permission permission) {
        return grants.get(permission);
    }
    
    public void clearPermissions() {
        permissions.clear();
    }
    
    public void clearGrants() {
        grants.clear();
    }
    
    public void clearAll() {
        permissions.clear();
        grants.clear();
    }

    private String grantsToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Permission, Scope[]> entry : grants.entrySet()) {
            sb.append(entry.getKey()).append(": [\n");
            for (Scope scope : entry.getValue()) {
                sb.append(scope).append(",\n");
            }
            sb.append("],\n");
        }
        return sb.toString();
    }

    private String permissionsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Map.Entry<Integer, Permission> entry : permissions.entrySet()) {
            sb.append(entry.getValue()).append(",\n");
        }
        sb.append("],\n");
        return sb.toString();
    }

    public String toJsonLike() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"name\": \"").append(name).append("\",\n");
        sb.append("\"age\": ").append(age).append(",\n");
        sb.append("\"role\": \"").append(role).append("\",\n");
        sb.append("\"permissions\": ").append(permissionsToString()).append(",\n");
        sb.append("\"grants\": ").append(grantsToString()).append("\n");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User”{name:").append(name)
        .append(", age:").append(age)
        .append(", role:").append(role)
        .append(", permissions:").append(permissions)
        .append(", grants:").append(grantsToString()).append('}');
        return sb.toString();
    }
}