package org.example;

public class Node {

    protected Node left;
    protected Node right;
    protected BinarySearchTree commandTree;
    protected String key;
    protected String text;
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

    public Node getCommandNode(String command) {
        return null;
    }

    public BinarySearchTree getCommandTree() {

        return null;

    }

}
