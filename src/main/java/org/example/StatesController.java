package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;


public class StatesController {


    private Window window;
    private Inventory inventory;
    private ObjectMapper objectMapper;
    protected States states;

    public StatesController() throws IOException {

        //create window and pass back updateState function to detect input from window
        this.window = new Window(this::updateState);

        //create new inventory
        inventory = new Inventory();

        //make states available to objectMapper so the JSON file can be read and parsed
        states = new States();

        window.setTextArea("Press enter to begin game" + "\n");

    }

    public void updateState(String inputFromWindow) {

        inputFromWindow = inputFromWindow.toLowerCase();
        inputFromWindow = inputFromWindow.replace(" ", "");


    }
}
