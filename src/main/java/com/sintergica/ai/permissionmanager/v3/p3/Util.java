package com.sintergica.ai.permissionmanager.v3.p3;

import com.sintergica.ai.permissionmanager.v3.p1.Permission;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Util {
    public String name;
    public String permission;
    public final Map<UUID,String> permissions;
    public static final String separator = "::";

    public Util(String name) {
        this.name = name;
        this.permission = "";
        this.permissions = new HashMap<>();
    }

    public String test(){

        int permissions1 = 0;
        ScopeType scope1 = ScopeType.USERS;
        UUID id = UUID.randomUUID();

        permissions1 ^= Permission.LEER.valor;
        permissions1 ^= Permission.ESCRIBIR.valor;

        StringBuilder sb = new StringBuilder();
        sb.append(scope1)
                .append(separator)
                .append(permissions1)
                .append(separator)
                .append(id);
        return sb.toString().trim();
    }

    public void test2(){
        String perms =  this.test();

        String[] split = perms.split(separator);

        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
    }

    private int managePerms(Permission permissions, UUID scopeId) {
        String permissionsTmp = this.permissions.get(scopeId);
        String[] permissionsTmp1 = permissionsTmp.split(separator);
        int permissionsTmp2 = Integer.parseInt(permissionsTmp1[1]);

        permissionsTmp2 ^= permissions.valor ;

        permissionsTmp = permissionsTmp1[0] + separator + permissionsTmp2;

        this.permissions.replace(scopeId,permissionsTmp);
        return permissionsTmp2;
    }

    public void addToPermissions(ScopeType scope, Permission permissions, UUID scopeId){

        if(this.permissions.containsKey(scopeId)){
            managePerms(permissions, scopeId);
        }else {
            this.permissions.put(scopeId,scope + separator + String.valueOf(permissions.valor));
        }

    }



    public void removeFromPermissions(ScopeType scope, Permission permissions, UUID scopeId){
        if(this.permissions.containsKey(scopeId)){
            if(managePerms(permissions, scopeId) == 0){
                this.permissions.remove(scopeId);
            }
        }
    }
/*
    private String[] splitter() { return this.permission.split(separator); }

    public void setPermissionsI(ScopeType scope, int permissions, String scopeId){
        String sb = scope +
                separator +
                permissions +
                separator +
                scopeId;
        this.permission = sb.trim();
    }

    public void addPermissionsI(ScopeType scope, int permissions, String scopeId){
        String sb = scope +
                separator +
                permissions +
                separator +
                scopeId;
        this.permission = sb.trim();
    }

    public ScopeType getScopeI(){ return ScopeType.valueOf(this.splitter()[0]); }

    public int getPermissionsI() { return Integer.parseInt(this.splitter()[1]); }

    public UUID getId(){ return UUID.fromString(this.splitter()[2]); }*/

    public String getPermission() {
        return permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
