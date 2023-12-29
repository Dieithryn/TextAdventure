package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class States {
    private String stateTexts;
    private String stateName;
    private String currentState;
    private JsonNode stateNode;
    private JsonNode stateTextNode;
    private ObjectMapper objectMapper;


        public States() throws IOException {

            objectMapper = new ObjectMapper();
            stateNode = objectMapper.readTree(new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\resources\\StateTexts.json"));

        }
        public String getStateText(String stateName) {

            try {
                stateTextNode = stateNode.get(stateName);
                stateTexts = objectMapper.writeValueAsString(stateTextNode.get("stateText"));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return stateTexts;
        }

        public String getCurrentState() {

            currentState = stateName;
            return currentState;
        }




}
