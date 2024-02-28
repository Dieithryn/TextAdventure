package org.example;

public class Node {

    protected Node left;
    protected Node right;
    protected String key;
    protected String text;
    protected String lookAround;
    protected int height;


    public Node() {
    }
    public Node(String key, String text) {

        this.key = key;
        this.text = text;
        this.height = 1;
        this.left = null;
        this.right = null;

    }


    public String getKey() {

        return this.key;

    }
    public String getText() {

        return this.text;

    }
    public String getLookAround() {
        return null;
    }

    public Node getCommandNode(String command) {
        return null;
    }

    public BinarySearchTree getCommandTree() {

        return null;

    }

}
