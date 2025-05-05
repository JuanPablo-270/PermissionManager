package com.sintergica.ai.permissionmanager.v3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonParser {
    public static void parse(Object obj) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try {
            String json = ow.writeValueAsString(obj);
            System.out.println(json);
        } catch (JsonProcessingException ignored) {
        }//*/
    }
}
