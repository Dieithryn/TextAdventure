package org.example;



import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class StatesController {

    private States stateZero;
    private States stateOne;
    private States stateTwo;
    private States stateThree;
    private States stateFour;
    private States stateFive;
    private Window window;
    private Inventory inventory;
    private String quantityInitial;
    protected States currentState;

    public StatesController() {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        inventory = new Inventory();

        //initialize states that will control text on screen
        stateZero = new States("ZERO \n", null, null);
        stateOne = new States("ONE \n", null, stateZero);
        stateTwo = new States("TWO \n", null, stateOne);
        stateThree = new States("THREE \n", null, stateOne);
        stateFour = new States("FOUR \n", null, stateOne);
        stateFive = new States("FIVE \n", null, stateOne);

        stateZero.setNextState(stateOne);

        stateOne.setNextState(stateTwo);

        stateOne.setStateText("You are in a rainforest. The it is silent save for a harsh wind blustering through the trees. The wildlife has taken shelter from the oncoming storm. You have a compass, a dead walkie-talkie,and 2 matches.");

        stateTwo.setStateText("You journey south. The rainforest thickens around you. The canopy above blots out the little light you had left from the overcast sky. A small snake slithers by your foot.");

        stateThree.setStateText("You journey north. The rainforest thins. Chunks of canopy are missing from above revealing the overcast sky. The crunch of the leaves beneath your feet grows louder with each step. The trees are rotting.");

        stateFour.setStateText("You journey west. A wide river cuts your journey short. Rapidly fleeing water crashes against rocky outcroppings spraying droplets into the air.");

        stateFive.setStateText("You journey east. The ground dips down with an easy slope before a sudden cliff that makes a valley with another across from it. You spy a cave on the adjacent cliff.");

        currentState = stateZero;

        window.setTextArea("Press enter to begin game" + "\n");

    }


    public String getCurrentState() {

        return currentState.getState();

    }

    public void updateState(String inputFromWindow) {

        System.out.println(inputFromWindow);

        if (inputFromWindow.equals("") && currentState.getState().equals("ZERO \n")) {
            currentState = currentState.getNextState();

            inventory.setQuantity(0,1);
            inventory.setQuantity(1,1);
            inventory.setQuantity(2, 2);

            System.out.println(currentState.getStateText() + "\n");
            window.setTextArea(currentState.getStateText() + "\n");

        } else {
            System.out.println("eror");
        }

        if (inputFromWindow.equals("Go south") && currentState.getState().equals("ONE \n")) {
            currentState = currentState.getNextState();

            System.out.println(currentState.getStateText() + "\n");
            window.setTextArea(currentState.getStateText() + "\n");
        } else if (inputFromWindow.equals("Go north") && currentState.getState().equals("ONE \n")) {

            currentState.setNextState(stateThree);

            currentState = currentState.getNextState();
            System.out.println(currentState.getStateText() + "\n");
            window.setTextArea(currentState.getStateText() + "\n");
        } else if (inputFromWindow.equals("Go west") && currentState.getState().equals("ONE \n")) {
            currentState.setNextState(stateFour);

            currentState = currentState.getNextState();
            System.out.println(currentState.getStateText() + "\n");
            window.setTextArea(currentState.getStateText() + "\n");
        } else if (inputFromWindow.equals("Go east") && currentState.getState().equals("ONE \n")) {

            currentState.setNextState(stateFive);

            currentState = currentState.getNextState();
            System.out.println(currentState.getStateText() + "\n");
            window.setTextArea(currentState.getStateText() + "\n");
        }

    }

}
