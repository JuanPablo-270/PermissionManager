/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sintergica.ai.permissionmanager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sintergica.ai.permissionmanager.v2.Permission;
import com.sintergica.ai.permissionmanager.v2.Scope;
import com.sintergica.ai.permissionmanager.v2.User;

import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

/**
 *
 * @author panther
 */
public class PermissionManager {

    public static void main(String[] args) {
        
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
            e.printStackTrace();
        }

        //System.out.println("User: " + user.toJSONLike());
    }
}
