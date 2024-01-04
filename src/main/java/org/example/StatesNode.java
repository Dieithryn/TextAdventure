package org.example;

public class StatesNode extends BinarySearchTreeNode<String> {

    StatesNode left;
    StatesNode right;
    String key;
    public StatesNode() {

    }

    public StatesNode(String state) {

        this.key = state;
        this.left = new StatesNode();
        this.right = new StatesNode();

    }

    public String getKey(StatesNode node) {

        return key;

    }

}
