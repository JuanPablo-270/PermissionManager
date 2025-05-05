package com.sintergica.ai.permissionmanager;


import com.sintergica.ai.permissionmanager.v1.Alpha;
import com.sintergica.ai.permissionmanager.v2.Bravo;
import com.sintergica.ai.permissionmanager.v3.Charly;
import com.sintergica.ai.permissionmanager.v4.Delta;
import com.sintergica.ai.permissionmanager.v5.Echo;

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
        
        System.out.println("<-------------------------------------Delta------------------------------------->");
        Delta.run();
        
        System.out.println("<-------------------------------------Echo------------------------------------->");
        Echo.run();
    }
}
