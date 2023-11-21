package org.example;

import java.util.Scanner;

public class States {
    private String stateName;
    static States currentState, nextState, previousState;
        public void updateState() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.equals("1")) {
                currentState = nextState;
                break;
            } else {
                System.out.println("Eror");
                break;
            }
            }
        }

        public void setState(States state) {
            currentState = state;
        }

        public void setNextState(States nextState) {

            States.nextState = nextState;

        }

        public void setPrevState(States previousState) {

            States.previousState = previousState;

        }

        public void setStateName(String stateName) {

            this.stateName = stateName;
        }

        public void getState() {

            System.out.println(stateName);
        }



}
