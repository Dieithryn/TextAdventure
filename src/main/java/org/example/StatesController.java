package org.example;


import com.sun.source.tree.BinaryTree;

import java.io.IOException;
import java.util.Objects;


public class StatesController {

    private int count = 0;
    private Window window;
    private Inventory inventory;
    private StatesBinarySearchTree stateTree;
    private StatesNode stateNode;
    protected States states;

    public StatesController() {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        inventory = new Inventory();

        stateTree = new StatesBinarySearchTree();

        states = new States();

        stateNode = new StatesNode(states.getStateName());

        stateTree.insertNode(stateNode, stateNode.getCount());


    }

    public void updateState(String inputFromWindow) {

        inputFromWindow = inputFromWindow.toLowerCase();
        inputFromWindow = inputFromWindow.replace(" ", "");

        if (inputFromWindow.isEmpty() && Objects.equals(states.getCurrentState(), "StateZero")){

            window.setTextArea(states.getStateText("StateStart") + "\n");

        }

        if (inputFromWindow.equals("gosouth") && Objects.equals(states.getCurrentState(), "StateStart")) {

            window.setTextArea(states.getStateText("StateSnake") + "\n");

        }


    }
}
