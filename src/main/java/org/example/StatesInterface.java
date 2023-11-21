package org.example;

public interface StatesInterface {
    void updateState();
    void setState(States state);
    void setNextState(States nextState);
    void setPrevState(States prevState);
    void setStateName(String stateName);
    void getState();

}
