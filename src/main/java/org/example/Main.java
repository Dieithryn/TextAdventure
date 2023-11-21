package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Window window = new Window();
        Events events = new Events();
        Writer writer = new Writer();

        States stateZero = new States();
        States stateOne = new States();
        States stateTwo = new States();
        States stateThree = new States();

        States.currentState = stateZero;

        stateZero.setStateName("ZERO");
        stateZero.setNextState(stateOne);
        stateZero.setPrevState(null);

        stateOne.setStateName("ONE");
        stateOne.setNextState(stateTwo);
        stateOne.setPrevState(stateZero);

        stateTwo.setStateName("TWO");
        stateTwo.setNextState(stateThree);
        stateTwo.setPrevState(stateOne);

        stateThree.setStateName("THREE");
        stateThree.setNextState(null);
        stateThree.setPrevState(stateTwo);

        States.currentState = stateZero;

        while (true) {
            States.currentState.getState();
            States.currentState.updateState();
        }


    }
}