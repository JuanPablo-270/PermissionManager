package com.sintergica.ai.permissionmanager;


import com.sintergica.ai.permissionmanager.v1.Alpha;
import com.sintergica.ai.permissionmanager.v2.Bravo;
import com.sintergica.ai.permissionmanager.v3.Charly;

/**
 *
 * @author panther
 */
public class PermissionManager {

    public static void main(String[] args) {
        
        System.out.println("<-------------------------------------Alpha------------------------------------->");
        Alpha.run();
        
        System.out.println("<-------------------------------------Bravo------------------------------------->");
        Bravo.run();
        
        System.out.println("<-------------------------------------Charly------------------------------------->");
        Charly.run();
    }
}
