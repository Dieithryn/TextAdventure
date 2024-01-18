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

        //create state tree
        stateTree = new StatesBinarySearchTree();

        //instantiate to call file with state names later
        states = new States();

        //get state names and count them
        iter = states.getStateNames();
        while (iter.hasNext()) {
            count++;
            iter.next();
        }

        //set tree root to middle term
        stateTree.root = stateTree.insertNode((count/2));

        //reset iterator and count to load states into state tree
        iter = states.getStateNames();
        count = 0;
        while (iter.hasNext()) {

            stateTree.insertNode(count);
            count++;
            iter.next();

        }






        System.out.println(stateTree.search(5));
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
