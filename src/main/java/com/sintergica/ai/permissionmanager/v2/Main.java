package com.sintergica.ai.permissionmanager.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter; 


public class Main {
    public static void main(String[] args) {
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
            e.printStackTrace();
        }
    }
}