package com.sintergica.ai.permissionmanager.v5;

import java.util.UUID;

import com.sintergica.ai.permissionmanager.v5.entities.Knowledge;
import com.sintergica.ai.permissionmanager.v5.entities.Model;
import com.sintergica.ai.permissionmanager.v5.entities.User;
import com.sintergica.ai.permissionmanager.v5.util.JsonParser;

/**
 * Echo is a class that demonstrates the usage of the AccessManager and its
 * functionality.
 *
 * This class is used to test the AccessManager and its functionality. It
 * creates instances of models, users, and knowledge bases, and grants
 * permissions to users for those models and knowledge bases. It also
 * demonstrates how to check if a user has access to a specific model or
 * knowledge base.
 *
 * @author Panther
 */
public class Echo {

    /* <---------------Access Manager---------------> */
    private static final AccessManager accessManager = AccessManager.manager();
    private static final Model turing = new Model();
    private static final Model chatgpt = new Model();
    private static final User panther = new User();
    private static final User rose = new User();
    private static final Knowledge knowledge_base_turing = new Knowledge();
    private static final Knowledge knowledge_base_chatgpt = new Knowledge();



    private static void printAccessStatus() {
        System.out.println("Printing Access Status:\n\n");
        System.out.println("Panther can READ Turing?: " + accessManager.userCanAccess(panther.getID(), turing, Permission.READ));
        System.out.println("Panther can WRITE Turing?: " + accessManager.userCanAccess(panther.getID(), turing, Permission.WRITE));
        System.out.println("Panther can EXECUTE Turing?: " + accessManager.userCanAccess(panther.getID(), turing, Permission.EXECUTE));
        System.out.println("Panther can READ ChatGPT?: " + accessManager.userCanAccess(panther.getID(), chatgpt, Permission.READ));
        System.out.println("Panther can WRITE ChatGPT?: " + accessManager.userCanAccess(panther.getID(), chatgpt, Permission.WRITE));
        System.out.println("Panther can EXECUTE ChatGPT?: " + accessManager.userCanAccess(panther.getID(), chatgpt, Permission.EXECUTE));
        System.out.println("Rose can READ Turing?: " + accessManager.userCanAccess(rose.getID(), turing, Permission.READ));
        System.out.println("Rose can WRITE Turing?: " + accessManager.userCanAccess(rose.getID(), turing, Permission.WRITE));
        System.out.println("Rose can EXECUTE Turing?: " + accessManager.userCanAccess(rose.getID(), turing, Permission.EXECUTE));
        System.out.println("Rose can READ ChatGPT?: " + accessManager.userCanAccess(rose.getID(), chatgpt, Permission.READ));
        System.out.println("Rose can WRITE ChatGPT?: " + accessManager.userCanAccess(rose.getID(), chatgpt, Permission.WRITE));
        System.out.println("Rose can EXECUTE ChatGPT?: " + accessManager.userCanAccess(rose.getID(), chatgpt, Permission.EXECUTE));
        System.out.println("Rose can READ Knowledge Base Turing?: " + accessManager.userCanAccess(rose.getID(), knowledge_base_turing, Permission.READ));
        System.out.println("Rose can WRITE Knowledge Base Turing?: " + accessManager.userCanAccess(rose.getID(), knowledge_base_turing, Permission.WRITE));
        System.out.println("Rose can EXECUTE Knowledge Base Turing?: " + accessManager.userCanAccess(rose.getID(), knowledge_base_turing, Permission.EXECUTE));
        System.out.println("Rose can READ Knowledge Base ChatGPT?: " + accessManager.userCanAccess(rose.getID(), knowledge_base_chatgpt, Permission.READ));
        System.out.println("Rose can WRITE Knowledge Base ChatGPT?: " + accessManager.userCanAccess(rose.getID(), knowledge_base_chatgpt, Permission.WRITE));
        System.out.println("Rose can EXECUTE Knowledge Base ChatGPT?: " + accessManager.userCanAccess(rose.getID(), knowledge_base_chatgpt, Permission.EXECUTE));
        System.out.println("Panther can READ Knowledge Base Turing?: " + accessManager.userCanAccess(panther.getID(), knowledge_base_turing, Permission.READ));
        System.out.println("Panther can WRITE Knowledge Base Turing?: " + accessManager.userCanAccess(panther.getID(), knowledge_base_turing, Permission.WRITE));
        System.out.println("Panther can EXECUTE Knowledge Base Turing?: " + accessManager.userCanAccess(panther.getID(), knowledge_base_turing, Permission.EXECUTE));
        System.out.println("Panther can READ Knowledge Base ChatGPT?: " + accessManager.userCanAccess(panther.getID(), knowledge_base_chatgpt, Permission.READ));
        System.out.println("Panther can WRITE Knowledge Base ChatGPT?: " + accessManager.userCanAccess(panther.getID(), knowledge_base_chatgpt, Permission.WRITE));
        System.out.println("Panther can EXECUTE Knowledge Base ChatGPT?: " + accessManager.userCanAccess(panther.getID(), knowledge_base_chatgpt, Permission.EXECUTE));
        System.out.println("EOF Access Status:\n\n");
    }

    public static void run() {

        UUID id = UUID.fromString("1143fdc2-b7bd-4af3-abb3-90ce83545161");

        /* <---------------Models---------------> */
        turing.setName("Turing");
        turing.setID(id);

        chatgpt.setName("ChatGPT");
        chatgpt.setID(id);

        /* <---------------Users---------------> */
        panther.setName("Panther");
        panther.setID(UUID.fromString("6954f883-3bcc-43ad-b6a4-a7d50dbaf09a"));

        
        rose.setName("Rose");
        rose.setID(UUID.fromString("e7912251-25aa-4082-9238-eaa5e859b558"));

        /* <---------------Groups---------------> */

        /* <---------------Knowledge Bases---------------> */
        knowledge_base_turing.setName("Knowledge Base Turing");

        knowledge_base_chatgpt.setName("Knowledge Base ChatGPT");


        /* <---------------Granting Access---------------> */
        accessManager.grantAccess(panther.getID(), knowledge_base_turing, Permission.READ);
        accessManager.grantAccess(panther.getID(), knowledge_base_turing, Permission.WRITE);
        accessManager.grantAccess(panther.getID(), knowledge_base_turing, Permission.EXECUTE);

        accessManager.grantAccess(panther.getID(), knowledge_base_chatgpt, Permission.READ);
        accessManager.grantAccess(panther.getID(), knowledge_base_chatgpt, Permission.WRITE);
        accessManager.grantAccess(panther.getID(), knowledge_base_chatgpt, Permission.EXECUTE);

        accessManager.grantAccess(panther.getID(), turing, Permission.READ);
        accessManager.grantAccess(panther.getID(), turing, Permission.WRITE);
        accessManager.grantAccess(panther.getID(), turing, Permission.EXECUTE);

        accessManager.grantAccess(rose.getID(), chatgpt, Permission.READ);
        accessManager.grantAccess(panther.getID(), chatgpt, Permission.WRITE);
        accessManager.grantAccess(rose.getID(), chatgpt, Permission.EXECUTE);

        /* <---------------Checking Access---------------> */
        printAccessStatus();

        /* <---------------JSON Parser---------------> */
        JsonParser.parse(knowledge_base_turing);
        JsonParser.parse(knowledge_base_chatgpt);

        JsonParser.parse(turing);
        JsonParser.parse(chatgpt);

        /* <---------------Revoking Access---------------> */
        accessManager.revokeAccess(panther.getID(), turing, Permission.WRITE);
        accessManager.revokeAccess(panther.getID(), turing, Permission.EXECUTE);
        accessManager.revokeAccess(panther.getID(), chatgpt, Permission.WRITE);
        accessManager.revokeAccess(panther.getID(), chatgpt, Permission.EXECUTE);

        accessManager.revokeAccess(rose.getID(), chatgpt, Permission.WRITE);
        accessManager.revokeAccess(rose.getID(), chatgpt, Permission.EXECUTE);

        accessManager.revokeAccess(panther.getID(), knowledge_base_turing, Permission.WRITE);
        accessManager.revokeAccess(panther.getID(), knowledge_base_turing, Permission.EXECUTE);
        /* <---------------Checking Access---------------> */
        printAccessStatus();

        /* <---------------JSON Parser---------------> */
        JsonParser.parse(knowledge_base_turing);
        JsonParser.parse(knowledge_base_chatgpt);

        JsonParser.parse(turing);
        JsonParser.parse(chatgpt);
    }
}
