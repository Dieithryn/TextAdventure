package org.example;


import java.util.Scanner;

public class StatesController {

    protected States currentState;

    public StatesController() {

        States stateZero = new States("ZERO", null, null);
        States stateOne = new States("ONE", null, stateZero);
        States stateTwo = new States("TWO", null, stateOne);
        States stateThree = new States("THREE", null, stateTwo);

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
            String input = scanner.next();
            if (input.equals("1")) {
                currentState = currentState.getNextState();
                break;
            } else {
                System.out.println("Eror");
                break;
            }
        }
        }
    }
