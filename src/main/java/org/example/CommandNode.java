package org.example;

public class CommandNode {


    private String command;
    private States nextState;
    private CommandNode left;
    private CommandNode right;

    public CommandNode(String command, States nextState) {

        this.command = command;
        this.nextState = nextState;

    }

    public void setLeft(CommandNode left) {

        this.left = left;

    }

    public void setRight(CommandNode right) {

        this.right = right;
    }

    public CommandNode getLeft() {

        return left;

    }

    public CommandNode getRight() {

        return right;

    }

}
