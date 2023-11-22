package org.example;

import java.util.Scanner;

public class States {
    private String stateName;
    protected States nextState, previousState;

        public States(String stateName, States nextState, States previousState) {

            this.stateName = stateName;
            this.nextState = nextState;
            this.previousState = previousState;

        }

        public void updateState() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.equals("1")) {
                break;
            } else {
                System.out.println("Eror");
                break;
            }
            }
        }

        public void setNextState(States nextState) {

            this.nextState = nextState;

        }
        public States getNextState() {
            return nextState;
        }

        public void setPrevState(States previousState) {

            this.previousState = previousState;

        }

        public void setStateName(String stateName) {

            this.stateName = stateName;
        }

        public String getState() {
            return stateName;
        }



}
