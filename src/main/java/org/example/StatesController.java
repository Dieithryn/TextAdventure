package org.example;



import java.util.Scanner;

public class StatesController {

    private String inputFromWindow;
    protected States currentState;

    public StatesController() {

        States stateZero = new States("ZERO \n", null, null);
        States stateOne = new States("ONE \n", null, stateZero);
        States stateTwo = new States("TWO \n", null, stateOne);
        States stateThree = new States("THREE \n", null, stateTwo);

        stateZero.setNextState(stateOne);
        stateOne.setNextState(stateTwo);

        currentState = stateZero;

    }

    public String getCurrentState() {

        return currentState.getState();

    }

    public void updateState() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            inputFromWindow = scanner.next();
            if (inputFromWindow.equals("1")) {
                currentState = currentState.getNextState();
                break;
            } else {
                System.out.println("Eror");
                break;
            }
        }
    }

}
