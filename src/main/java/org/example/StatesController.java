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


        //set root to null node
        stateTree.root = stateTree.insertNode(null,0);

        //reset iterator and count to load states into state tree
        iter = states.getStateNames();
        count = 1;
        while (iter.hasNext()) {

            stateTree.root = stateTree.insertNode(iter.next(), count);
            count++;

        }


    }

    public void updateState(String inputFromWindow) {

        inputFromWindow = inputFromWindow.toLowerCase();
        inputFromWindow = inputFromWindow.replace(" ", "");


    }
}
