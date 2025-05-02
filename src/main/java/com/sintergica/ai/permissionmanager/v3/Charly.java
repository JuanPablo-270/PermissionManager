package com.sintergica.ai.permissionmanager.v3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sintergica.ai.permissionmanager.v3.p1.Permission;
import com.sintergica.ai.permissionmanager.v3.p1.Scope;
import com.sintergica.ai.permissionmanager.v3.p1.User;

public class Charly {

    public static final int UPPERCASE = 1;  // 0001
    public static final int REVERSE = 2;  // 0010
    public static final int FULL_STOP = 4;  // 0100
    public static final int EMPHASISE = 8;  // 1000
    public static final int ALL_OPTS = 15; // 1111

    public static String stringFormatter(String value, int flags) {
        if ((flags & UPPERCASE) == UPPERCASE) {
            value = value.toUpperCase();
        }

        if ((flags & REVERSE) == REVERSE) {
            value = new StringBuffer(value).reverse().toString();
        }

        if ((flags & FULL_STOP) == FULL_STOP) {
            value += ".";
        }

        if ((flags & EMPHASISE) == EMPHASISE) {
            value = "~*~ " + value + " ~*~";
        }

        return value;
    }

    public static void testStringFormatter(){
        String value = "Hello World";
        String value1 = "Poor";
        int flags = EMPHASISE | FULL_STOP;

        if ((flags & EMPHASISE) == EMPHASISE) {
            value1 = "~*~ " + value1 + " ~*~";
            System.out.println(value1);
            System.out.println(flags);
        }

            
        System.out.println(
            stringFormatter(value, UPPERCASE)
            ); // JOE

        System.out.println(
            stringFormatter(value, REVERSE)
            ); // eoJ

        System.out.println(
            stringFormatter(value, FULL_STOP | EMPHASISE)
            ); // ~*~ Joe. ~*~

        System.out.println(
            stringFormatter(value, ALL_OPTS)
            ); // ~*~ EOJ. ~*~

        System.out.println(
            stringFormatter(value, UPPERCASE | EMPHASISE)
            ); 
    }
    
    public static void permissionbit(){
        int perms = 0;
        perms |= Permission.LEER.valor;
        perms |= Permission.ESCRIBIR.valor;
        System.out.println("Permisos: " + perms);
        System.out.println("Permisos: " + Integer.toBinaryString(perms));
    }

    public static void run(){
        User user = new User("Juan");
        user.addPermission(Permission.LEER);
        user.addPermission(Permission.ESCRIBIR);

        user.addPermission(Scope.SYSTEM, Permission.LEER);
        
        System.out.println("EX: " + user + " Perms: " + user.getPermissions());
        
        user.removePermission(Permission.ESCRIBIR);
        
        System.out.println("EX: " + user + " Perms: " + user.getPermissions());

        user.addPermission(Scope.SYSTEM, Permission.ESCRIBIR);
        user.addPermission(Scope.SYSTEM, Permission.ELIMINAR);
        user.addPermission(Scope.COMPANY, Permission.ESCRIBIR);
        user.addPermission(Scope.GROUP, Permission.ESCRIBIR);

        
        System.out.println("User: "+ user.getName() + " tiene permisos: " + user.getPermissions());
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        
        try {
            String json = ow.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }//*/

        System.out.println("User: "+ user.getName() + " tiene permisos en cada ambito: " + user.getPermissionsByScopeAsString());

        System.out.println("User permisos eliminados ----------- ");

        user.removePermission(Scope.SYSTEM, Permission.ESCRIBIR);
        
        System.out.println("User: "+ user.getName() + " tiene permisos: " + user.getPermissionsAsString());



        try {
            String json = ow.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }//*/

        System.out.println("User: "+ user.getName() + " tiene permisos en cada ambito: " + user.getPermissionsByScopeAsString());
        
        user.removePermission(Scope.SYSTEM, Permission.ELIMINAR);
        
        System.out.println("User: "+ user.getName() + " tiene permisos en cada ambito: " + user.getPermissionsByScopeAsString());

        try {
            String json = ow.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }//*/
    }
}