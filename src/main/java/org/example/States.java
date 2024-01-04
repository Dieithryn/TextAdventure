package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class States {
    private String stateTexts;
    private String currentState;
    private JsonNode stateNode;
    private JsonNode stateTextNode;
    private ObjectMapper objectMapper;


        public States() {

            objectMapper = new ObjectMapper();
            try {
                stateNode = objectMapper.readTree(new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\resources\\StateTexts.json"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public void setState(String state) {

            this.currentState = state;

        }
        public String getStateText(String stateName) {

            try {
                stateTextNode = stateNode.get(stateName);
                stateTexts = objectMapper.writeValueAsString(stateTextNode.get("stateText"));
                stateTexts = stateTexts.replace("\"", "");

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return stateTexts;
        }

        public String getCurrentState() {

            return currentState;
        }




}
