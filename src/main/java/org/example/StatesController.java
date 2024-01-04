package org.example;


import com.sun.source.tree.BinaryTree;

import java.io.IOException;
import java.util.Objects;


public class StatesController {


    private Window window;
    private Inventory inventory;
    private String stateZero = "StateZero";
    private StatesBinarySearchTree stateTree;
    protected States states;

    public StatesController() {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        inventory = new Inventory();

        //create states object
        states = new States();
        states.setState(stateZero);

        stateTree = new StatesBinarySearchTree();

        window.setTextArea(states.getStateText(stateZero) + "\n");




    }

    public void updateState(String inputFromWindow) {

        inputFromWindow = inputFromWindow.toLowerCase();
        inputFromWindow = inputFromWindow.replace(" ", "");

        if (inputFromWindow.isEmpty() && Objects.equals(states.getCurrentState(), "StateZero")){

            states.setState("StateStart");
            window.setTextArea(states.getStateText("StateStart") + "\n");

        }

        if (inputFromWindow.equals("gosouth") && Objects.equals(states.getCurrentState(), "StateStart")) {

            states.setState("StateSnake");
            window.setTextArea(states.getStateText("StateSnake") + "\n");

        }


    }
}
