package com.sintergica.ai.permissionmanager.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter; 


public class Bravo {

    public static void test(){
        User user = new User(
            "Panther","panther@gameover.com", "GameOver"
            );
        

        
        user.addGrant(Permission.READ, Scope.GROUP, Scope.MEMBERS);
        user.addGrant(Permission.READ, Scope.GROUP, Scope.KNOWLEDGE_BASE);
        
        
        user.addGrant(Permission.READ, Scope.COMPANY, Scope.COMPANY);
        user.addGrant(Permission.READ, Scope.COMPANY, Scope.GROUP);
        user.addGrant(Permission.READ, Scope.COMPANY, Scope.KNOWLEDGE_BASE);
        
        user.addGrant(Permission.READ, Scope.COMPANY, Scope.USER);
        
        
        user.addGrant(Permission.WRITE, Scope.COMPANY, Scope.COMPANY);
        user.addGrant(Permission.WRITE, Scope.COMPANY, Scope.GROUP);
        user.addGrant(Permission.WRITE, Scope.COMPANY, Scope.KNOWLEDGE_BASE);
        
        user.addGrant(Permission.WRITE, Scope.GROUP, Scope.MEMBERS);
        user.addGrant(Permission.WRITE, Scope.GROUP, Scope.KNOWLEDGE_BASE);
        
                
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        
        try {
            String json = ow.writeValueAsString(user);
            //System.out.println("ResultingJSONstring = " + json);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }

        //System.out.println("User: " + user.toJSONLike());
    }

    public static void run() {
        System.out.println("Hello, World!");

        User user = new User(
            "Panther",
            "panther@gameover.com",
            "GameOver"
        );
        
        user.addGrant(
            Permission.READ,
            Scope.ALL_SCOPES,
            Scope.ALL_SCOPES
        );

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        
        try {
            String json = ow.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        }
    }
}