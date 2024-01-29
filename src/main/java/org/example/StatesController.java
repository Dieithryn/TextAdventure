package org.example;

import java.util.Iterator;


public class StatesController {

    private String stateName;
    private String commandName;
    private Window window;
    private Inventory inventory;
    private BinarySearchTree stateTree;
    private BinarySearchTree commandsTree;
    private Iterator<String> statesIter;
    private Iterator<String> commandsIter;
    protected States states;

    public StatesController() {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        this.inventory = new Inventory();

        //create state tree
        this.stateTree = new BinarySearchTree();

        //instantiate to call file with state names later
        this.states = new States();


        //reset iterator and count to load states into state tree
        this.statesIter = states.getStateNames();
        while (statesIter.hasNext()) {

            stateName = statesIter.next();


                commandsTree = new BinarySearchTree();
                commandsIter = states.getCommands(stateName);

                if (states.getCommands(stateName) != null) {

                    while (commandsIter.hasNext()) {

                        commandName = commandsIter.next();
                        commandsTree.root = commandsTree.insertNode(commandName, states.getNextState(stateName, commandName), null);

                    }
                }

            stateTree.root = stateTree.insertNode(stateName, states.getStateText(stateName), commandsTree);

        }

        window.setTextArea(stateTree.searchForNode("StateZero").getText() + "\n");
        states.setCurrentState(stateTree.searchForNode("StateZero").getKey());
    }

    public void updateState(String inputFromWindow) {

        inputFromWindow = inputFromWindow.toLowerCase().replace(" ", "");;

        try {

            states.setCurrentState(stateTree.searchForNode(states.getCurrentState()).getCommandNode(inputFromWindow).getText());
            window.setTextArea(states.getStateText(states.getCurrentState()) + "\n");

        } catch (NullPointerException e) {

            window.setTextArea("Invalid input \n");

        }


    }
}
