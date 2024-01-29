package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class States {
    private String currentState;
    private String stateTexts;
    private String nextState;
    private JsonNode stateNode;
    private JsonNode stateTextNode;
    private JsonNode commandsNode;
    private ObjectMapper objectMapper;


        public States() {

            objectMapper = new ObjectMapper();

            try {
                stateNode = objectMapper.readTree(new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\resources\\StateTexts.json"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public void setCurrentState(String state) {

            this.currentState = state;

        }

        public Iterator<String> getStateNames() {

            return stateNode.fieldNames();

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

    public Iterator<String> getCommands(String stateName) {

        commandsNode = stateNode.get(stateName);
        commandsNode = commandsNode.get("commands");
        if (commandsNode != null) {
            return commandsNode.fieldNames();
        } else {
            return null;
        }
    }

    public String getNextState(String stateName, String command) {

        commandsNode = stateNode.get(stateName);
        commandsNode = commandsNode.get("commands");
        try {
            nextState = objectMapper.writeValueAsString(commandsNode.get(command));
            nextState = nextState.replace("\"", "");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        return nextState;
    }

    public String getCurrentState() {

            return currentState;

    }




}
