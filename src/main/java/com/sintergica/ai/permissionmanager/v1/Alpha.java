package com.sintergica.ai.permissionmanager.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Alpha {
    public static void run() {
        User user = new User("Panther", 30, UserRole.SUPER_ADMIN);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        
        user.addPermission(Permission.FOLLOW);
        user.addPermission(Permission.UNFOLLOW);
        user.addPermission(Permission.LIKE);
        user.addPermission(Permission.DISLIKE);

        user.addGrant(Permission.WRITE, new Scope[]{Scope.MODEL, Scope.USER});
        user.addGrant(Permission.READ, new Scope[]{Scope.MODEL, Scope.USER});
        user.addGrant(Permission.LIKE, new Scope[]{Scope.MODEL, Scope.USER});

        
        try {
            String json = ow.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }

        user.addGrant(Permission.UNFOLLOW, new Scope[]{Scope.USER, Scope.GROUP});
        user.addGrant(Permission.FOLLOW, new Scope[]{Scope.GROUP, Scope.SYSTEM});

        
        try {
            String json = ow.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }
    }
}