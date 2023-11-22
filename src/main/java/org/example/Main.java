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
        StatesController statesController = new StatesController();






        while (true) {
            System.out.println(statesController.getCurrentState());
            statesController.updateState();
        }


    }
}