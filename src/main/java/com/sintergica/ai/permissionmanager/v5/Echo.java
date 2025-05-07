package com.sintergica.ai.permissionmanager.v5;

import java.util.UUID;

import com.sintergica.ai.permissionmanager.v5.entities.Knowledge;
import com.sintergica.ai.permissionmanager.v5.entities.Model;
import com.sintergica.ai.permissionmanager.v5.entities.User;
import com.sintergica.ai.permissionmanager.v5.util.JsonParser;
public class Echo {

    public static void run() {
        
        UUID id = UUID.fromString("1143fdc2-b7bd-4af3-abb3-90ce83545161");

        /* <---------------Models---------------> */
        Model turing = new Model();
        turing.setName("Turing");
        turing.setID(id);

        Model chatgpt = new Model();
        chatgpt.setName("ChatGPT");
        chatgpt.setID(id);

        /* <---------------Users---------------> */
        User panther = new User();
        panther.setName("Panther");
        panther.setID(UUID.fromString("6954f883-3bcc-43ad-b6a4-a7d50dbaf09a"));

        User rose = new User();
        rose.setName("Rose");
        rose.setID(UUID.fromString("e7912251-25aa-4082-9238-eaa5e859b558"));

        /* <---------------Groups---------------> */

        /* <---------------Knowledge Bases---------------> */
        Knowledge knowledge_base_turing = new Knowledge();
        knowledge_base_turing.setName("Knowledge Base Turing");
        
        Knowledge knowledge_base_chatgpt = new Knowledge();
        knowledge_base_chatgpt.setName("Knowledge Base ChatGPT");
        
        /* <---------------Access Manager---------------> */
        AccessManager accessManager = AccessManager.manager();

        //accessManager.manage(knowledge_base_turing);
        accessManager.grantAccess(panther.getID(), knowledge_base_turing, Permission.READ);
        //accessManager.grantAccess(panther.getID(), knowledge_base_turing, Permission.WRITE);
        //accessManager.grantAccess(panther.getID(), knowledge_base_turing, Permission.EXECUTE);

        //accessManager.manage(knowledge_base_chatgpt);
        //accessManager.grantAccess(panther.getID(), knowledge_base_chatgpt, Permission.READ);
        accessManager.grantAccess(panther.getID(), knowledge_base_chatgpt, Permission.WRITE);
        //accessManager.grantAccess(panther.getID(), knowledge_base_chatgpt, Permission.EXECUTE);

        //accessManager.manage(turing);
        // accessManager.grantAccess(panther.getID(), turing, Permission.READ);
        // accessManager.grantAccess(panther.getID(), turing, Permission.WRITE);
        accessManager.grantAccess(panther.getID(), turing, Permission.EXECUTE);

        //accessManager.manage(chatgpt);
        accessManager.grantAccess(rose.getID(), chatgpt, Permission.READ);
        accessManager.grantAccess(panther.getID(), chatgpt, Permission.WRITE);
        accessManager.grantAccess(rose.getID(), chatgpt, Permission.EXECUTE);

        JsonParser.parse(knowledge_base_turing);
        JsonParser.parse(knowledge_base_chatgpt);

        JsonParser.parse(turing);
        JsonParser.parse(chatgpt);


        System.out.println("Panther can READ Turing?: " + accessManager.userCanAccess(panther.getID(), turing, Permission.READ));
    }

    public static void main(String[] args) {
        run();
    }
}
