package org.example;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;


public class StatesController {

    private Scanner scanner;
    private String stateNameInput;
    private String commandInput;
    private String nextStateInput;
    private String stateName;
    private String commandName;
    private String stateTexts;
    private String nextState;
    private JsonNode stateNode;
    private JsonNode stateTextNode;
    private JsonNode commandsNode;
    private ObjectMapper objectMapper;
    private Window window;
    private Inventory inventory;
    private BinarySearchTree stateTree;
    private BinarySearchTree commandsTree;
    private Iterator<String> statesIter;
    private Iterator<String> commandsIter;
    private JsonFactory factory;
    private JsonGenerator generator;
    protected States states;

    public StatesController() {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        this.inventory = new Inventory();

        //create state tree
        this.stateTree = new BinarySearchTree();

        this.states = new States();

        this.objectMapper = new ObjectMapper();

        try {
            stateNode = objectMapper.readTree(new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\resources\\StateTexts.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.statesIter = getStateNames();
        while (statesIter.hasNext()) {

            stateName = statesIter.next();


                commandsTree = new BinarySearchTree();
                commandsIter = getCommands(stateName);

                if (getCommands(stateName) != null) {

                    while (commandsIter.hasNext()) {

                        commandName = commandsIter.next();
                        commandsTree.root = commandsTree.insertNode(commandName, getNextState(stateName, commandName), null, null);

                    }
                }

            stateTree.root = stateTree.insertNode(stateName, getStateText(stateName), getLookAround(stateName), commandsTree);
        }

        window.setTextArea(stateTree.searchForNode("StateZero").getText() + "\n");
        states.setCurrentState(stateTree.searchForNode("StateZero").getKey());
        inventory.setQuantity(0, 1);
        inventory.setQuantity(1, 1);
        inventory.setQuantity(2,2);
    }

    public void updateState(String inputFromWindow) {

        if (inputFromWindow.equals("ADMIN")) {

            states.setAdminState(true);

        } else if (inputFromWindow.equals("STOP")) {

            states.setAdminState(false);
        }

        if (!states.getAdminState()) {
            window.setTextArea("> " + inputFromWindow + "\n");
            inputFromWindow = inputFromWindow.toLowerCase().replace(" ", "");

            try {

                if (inputFromWindow.equals("lookaround")){

                    window.setTextArea(getLookAround(states.getCurrentState()) + "\n");

                } else if (inputFromWindow.equals("help")) {

                    window.setTextArea("Feeling stuck? Sorry about that. Here are a few tips: \n 1) Commands are typically 2-3 words \n 2) Important objects will always be described in the scene \n 3) When in doubt, 'Look around' for some extra guidance! \n");

                } else if (inputFromWindow.equals("pickupsnake") && states.getCurrentState().equals("StateSnake") && inventory.getQuantity(3) == 0) {

                    inventory.setQuantity(3, 1);
                    window.setTextArea("The snake has been added to your inventory");

                } else if (inputFromWindow.equals("inventory")) {

                    window.setTextArea("Inventory:\n");
                    Arrays.stream(inventory.items).iterator().forEachRemaining(i -> {
                        if (i.getQuantity() >= 1) {
                            window.setTextArea(" - " + i.getName() + ": " + i.getQuantity() + "\n");
                        }
                    });

                } else {

                    states.setCurrentState(stateTree.searchForNode(states.getCurrentState()).getCommandNode(inputFromWindow).getText());
                    window.setTextArea(getStateText(states.getCurrentState()) + "\n");

                }



            } catch (NullPointerException e) {

                window.setTextArea("Invalid input \n");

            }
        } else {


            scanner = new Scanner(System.in);

            do {
                System.out.print("StateName: ");
                stateNameInput = scanner.next();


                if (stateNameInput.equals("STOP")) {
                    break;
                }

                commandsTree = new BinarySearchTree();

                do {

                    System.out.print("Command (END to finish): ");
                    commandInput = scanner.next();

                    if (commandInput.equals("END")) {
                        break;
                    }

                    System.out.print("NextState: ");
                    nextStateInput = scanner.next();

                    commandsTree.root = commandsTree.insertNode(commandInput, nextStateInput, null, null);

                } while (!commandInput.equals("END"));

                stateTree.root = stateTree.insertNode(stateNameInput, "", "", commandsTree);

            } while (!stateNameInput.equals("STOP"));

            writeState(stateTree.searchAll());
        }



    }

    private void writeState(Queue<Node> queue) {

        factory = new JsonFactory();

        try {

            generator = factory.createGenerator(new File("C:\\Users\\Luke\\IdeaProjects\\TextAdventure\\src\\main\\resources\\StateTexts.json"), JsonEncoding.UTF8);
            generator.writeStartObject();
            generator.useDefaultPrettyPrinter();

            queue.forEach(i -> {
                    try {
                        generator.writeFieldName(i.getKey());

                        generator.writeStartObject();

                        generator.writeFieldName("commands");
                        generator.writeStartObject();


                        i.getCommandTree().searchAll().forEach(j -> {
                                try {

                                    generator.writeFieldName(j.getKey());
                                    generator.writeObject(j.getText());


                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                        });
                        generator.writeEndObject();
                        generator.writeFieldName("stateText");
                        generator.writeObject(i.getText());
                        generator.writeFieldName("lookAround");
                        generator.writeObject(i.getLookAround());
                        generator.writeEndObject();

                    } catch (IOException e) {

                        throw new RuntimeException(e);

                    }
            });

            generator.close();

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
    private String getNextState(String stateName, String command) {

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
    private Iterator<String> getStateNames() {

        return stateNode.fieldNames();

    }
    private Iterator<String> getCommands(String stateName) {

        commandsNode = stateNode.get(stateName);
        commandsNode = commandsNode.get("commands");
        if (commandsNode != null) {
            return commandsNode.fieldNames();
        } else {
            return null;
        }
    }
    private String getStateText(String stateName) {

        try {
            stateTextNode = stateNode.get(stateName);
            stateTexts = objectMapper.writeValueAsString(stateTextNode.get("stateText"));
            stateTexts = stateTexts.replace("\"", "");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return stateTexts;
    }
    private String getLookAround(String stateName) {

        try {
            stateTextNode = stateNode.get(stateName);
            stateTexts = objectMapper.writeValueAsString(stateTextNode.get("lookAround"));
            stateTexts = stateTexts.replace("\"", "");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return stateTexts;
    }
}
