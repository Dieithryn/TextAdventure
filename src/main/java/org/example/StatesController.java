package org.example;

import java.util.Iterator;
import java.util.Objects;


public class StatesController {

    private Window window;
    private Inventory inventory;
    private StatesBinarySearchTree stateTree;
    private StatesNode stateNode;
    private Iterator<String> iter;
    protected int count;
    protected States states;

    public StatesController() {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        inventory = new Inventory();

        stateTree = new StatesBinarySearchTree();

        states = new States();

        stateNode = new StatesNode();

        iter = states.getStateNames();
        while (iter.hasNext()) {

            stateNode.setCount(count++);
            iter.next();

        }

        iter = states.getStateNames();
        count = 0;

        while (iter.hasNext()) {

            stateNode.key = iter.next();
            stateNode.numKey = count;
            stateTree.insertNode(stateNode, count);
            count++;

        }
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
