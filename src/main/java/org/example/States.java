package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class States {

    private boolean adminState;
    private String currentState;


        public States() {

        }

        public void setCurrentState(String state) {

            this.currentState = state;

        }
        public void setAdminState(boolean adminState) {

            this.adminState = adminState;

        }

        public String getCurrentState() {

            return currentState;

        }
        public boolean getAdminState() {
            return adminState;
    }






}
