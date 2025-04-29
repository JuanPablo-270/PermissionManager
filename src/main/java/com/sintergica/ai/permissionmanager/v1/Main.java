package com.sintergica.ai.permissionmanager.v1;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        User user = new User("Panther", 30, UserRole.SUPER_ADMIN);

        user.addPermission(Permission.FOLLOW);
        user.addPermission(Permission.UNFOLLOW);
        user.addPermission(Permission.LIKE);
        user.addPermission(Permission.DISLIKE);

        user.addGrant(Permission.WRITE, new Scope[]{Scope.MODEL, Scope.USER});
        user.addGrant(Permission.READ, new Scope[]{Scope.MODEL, Scope.USER});
        user.addGrant(Permission.LIKE, new Scope[]{Scope.MODEL, Scope.USER});

        System.out.println("User: " + user.toJsonLike());

        user.addGrant(Permission.UNFOLLOW, new Scope[]{Scope.USER, Scope.GROUP});
        user.addGrant(Permission.FOLLOW, new Scope[]{Scope.GROUP, Scope.SYSTEM});

        System.out.println("User: " + user);
    }
}