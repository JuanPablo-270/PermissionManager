package com.sintergica.ai.permissionmanager.v5;

import java.util.List;
import java.util.UUID;

import com.sintergica.ai.permissionmanager.v3.JsonParser;
import com.sintergica.ai.permissionmanager.v3.p1.Permission;

public class Echo {

    public static class User {

        private String name;
        private UUID ID;

        public User(String name, UUID ID) {
            this.name = name;
            this.ID = ID;
        }

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
    }


    public static void printUser(PermissionEntity permissionEntity, List<User> users){
        for (User user : users) {
            System.out.println(
                    ">> User<"
                    + user.getName()
                    + " "
                    + user.getID()
                    + ">"
            );

            System.out.println(
                    user.getName()
                    + " Can Read "
                    + permissionEntity.getName()
                    + ": "
                    + permissionEntity.hasPermission(user.getID(), Permission.LEER)
            );
            System.out.println(
                    user.getName()
                    + " Can Execute "
                    + permissionEntity.getName()
                    + ": "
                    + permissionEntity.hasPermission(user.getID(), Permission.EJECUTAR)
            ); // True
            System.out.println(
                    user.getName()
                    + " Can Write "
                    + permissionEntity.getName()
                    + ": "
                    + permissionEntity.hasPermission(user.getID(), Permission.ESCRIBIR)
            ); // True
        }
    
    }

    public static void run() {

        PermissionEntity model1 = new PermissionEntity();
        PermissionEntity model2 = new PermissionEntity();

        UUID id0 = UUID.fromString("6954f883-3bcc-43ad-b6a4-a7d50dbaf09a");
        UUID id1 = UUID.fromString("e7912251-25aa-4082-9238-eaa5e859b558");
        UUID id2 = UUID.fromString("1143fdc2-b7bd-4af3-abb3-90ce83545161");

        User panther = new User("Panther", id0);
        User rose = new User("Rose", id1);


        model1.setName("Turing");
        model2.setName("Turing-La-Secuela");


        model1.setID(id2);

        model1.setPermission(id0, Permission.LEER);
        model1.setPermission(id0, Permission.ESCRIBIR);
        model1.setPermission(id0, Permission.ELIMINAR);

        model1.setPermission(id1, Permission.LEER);
        model1.setPermission(id1, Permission.ESCRIBIR);
        model1.setPermission(id1, Permission.ELIMINAR);

        model2.setPermission(id1, Permission.LEER);
        model2.setPermission(id1, Permission.ESCRIBIR);
        model2.setPermission(id1, Permission.ELIMINAR);

        JsonParser.parse(model1);
        JsonParser.parse(model2);

        List<User> users = List.of(panther, rose);
        printUser(model1, users);
        printUser(model2, users);

    }

    public static void main(String[] args) {
        run();
    }
}
