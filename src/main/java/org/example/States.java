package org.example;

import java.util.Scanner;

public class States {
    private String stateName;
    private String stateText;
    protected States nextState, previousState;

        public States(String stateName, States nextState, States previousState) {

            this.stateName = stateName;
            this.nextState = nextState;
            this.previousState = previousState;

        }

        public void setStateText(String stateText) {
            this.stateText = stateText;
        }
        public void setNextState(States nextState) {

            this.nextState = nextState;

        }
        public void setPrevState(States previousState) {

            this.previousState = previousState;

        }

        public void setStateName(String stateName) {

            this.stateName = stateName;
        }
        public States getNextState() {

            return nextState;
        }
        public States getPreviousState() {

            return previousState;

        }
        public String getState() {

            return this.stateName;
        }
        public String getStateText() {

            return stateText;

        }


}
