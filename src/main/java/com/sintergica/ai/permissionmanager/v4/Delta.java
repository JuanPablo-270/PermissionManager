package com.sintergica.ai.permissionmanager.v4;

import java.util.List;
import java.util.UUID;

import com.sintergica.ai.permissionmanager.v3.JsonParser;
import com.sintergica.ai.permissionmanager.v3.p1.Permission;

public class Delta {
    public static void printPermsNValues(){
        System.out.println("Perms: " + Permission.LEER);
        System.out.println("Perms: " + Permission.LEER.valor);

        System.out.println("Perms: " + Permission.ESCRIBIR);
        System.out.println("Perms: " + Permission.ESCRIBIR.valor);
        
        System.out.println("Perms: " + Permission.EJECUTAR);
        System.out.println("Perms: " + Permission.EJECUTAR.valor);

        System.out.println("Perms: " + Permission.ELIMINAR);
        System.out.println("Perms: " + Permission.ELIMINAR.valor);

    }
    
    private static void checkPerms(PermissionEntity entity, UUID resourceId){
        System.out.println("User can read?: " + entity.hasPermission(resourceId, Permission.LEER));
        System.out.println("User can write?: " + entity.hasPermission(resourceId, Permission.ESCRIBIR));
        System.out.println("User can execute?: " + entity.hasPermission(resourceId, Permission.EJECUTAR));
        System.out.println("User can delete?: " + entity.hasPermission(resourceId, Permission.ELIMINAR));
    }
    
    public static void run(){
        User user = new User();
        Group group = new Group();

        UUID id0 = UUID.fromString("6954f883-3bcc-43ad-b6a4-a7d50dbaf09a");
        UUID id1 = UUID.fromString("e7912251-25aa-4082-9238-eaa5e859b558");
        UUID id2 = UUID.fromString("1143fdc2-b7bd-4af3-abb3-90ce83545161");


        user.setName("Panther");
        user.setID(id1);
        
        group.setName("Dockson");
        group.setID(id2);


        // Establece permisos
        //user.setPermission(id0, Permission.LEER);
        user.setPermission(id0, Permission.EJECUTAR);
        group.setPermission(id0, Permission.ESCRIBIR);
        group.setPermission(id0, Permission.LEER);
        

        JsonParser.parse(user);
        JsonParser.parse(group);

        System.out.println(id0 + " <-------------------------------------User------------------------------------->");
        checkPerms(user, id0);
        System.out.println(id1 + " <-------------------------------------User------------------------------------->");
        checkPerms(user, id1);
        System.out.println(id2 + " <-------------------------------------User------------------------------------->");
        checkPerms(user, id2);
        System.out.println(id0 + " <-------------------------------------Group------------------------------------->");
        checkPerms(group, id0);
        System.out.println(id1 + " <-------------------------------------Group------------------------------------->");
        checkPerms(group, id1);
        System.out.println(id2 + " <-------------------------------------Group------------------------------------->");
        checkPerms(group, id2);
        
        ResourceAccessManager accessManager = new ResourceAccessManager();

        // Verifica permisos
        List<PermissionEntity> entities = List.of(user, group);
        boolean canRead = accessManager.canAccess(id0, Permission.LEER, entities);
        boolean canExec = accessManager.canAccess(id0, Permission.EJECUTAR, entities);
        boolean canWrite = accessManager.canAccess(id0, Permission.ESCRIBIR, entities);

        System.out.println("Can Read: " + canRead); // True
        System.out.println("Can Execute: " + canExec); // True
        System.out.println("Can Write: " + canWrite); // True
    }
}