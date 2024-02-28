package org.example;

public class StatesNode extends Node{

    protected BinarySearchTree commandTree;


    public StatesNode(String key, String text, String lookAround, BinarySearchTree commandTree) {

        this.commandTree = commandTree;
        this.key = key;
        this.text = text;
        this.lookAround = lookAround;
        this.height = 1;
        this.left = null;
        this.right = null;

    }
    public String getLookAround() {
        return lookAround;
    }

    public Node getCommandNode(String command){

        return commandTree.searchForNode(command);

    }

    public BinarySearchTree getCommandTree() {
        return commandTree;
    }


}
