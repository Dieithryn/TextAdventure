package org.example;



import java.io.IOException;
import java.util.Scanner;

public class StatesController {

    private Window window;
    protected States currentState;

    public StatesController() throws IOException {

        this.window = new Window(this::updateState);

        States stateZero = new States("ZERO \n", null, null);
        States stateOne = new States("ONE \n", null, stateZero);
        States stateTwo = new States("TWO \n", null, stateOne);
        States stateThree = new States("THREE \n", null, stateTwo);

        stateZero.setNextState(stateOne);
        stateOne.setNextState(stateTwo);

        currentState = stateZero;
        window.setTextArea("Press 1 to begin game \n");

    }


    public String getCurrentState() {

        return currentState.getState();

    }

    public void updateState(String inputFromWindow) {

        System.out.println(inputFromWindow);

        if (inputFromWindow.equals("1")) {
            currentState = currentState.getNextState();
            System.out.println(currentState.getState());
            window.setTextArea(currentState.getState());
        } else {
            System.out.println("Eror");
        }

    }

}
