package org.example;

public class StatesNode extends BinarySearchTreeNode<String> {

    StatesNode left;
    StatesNode right;
    String key;
    int count = 0;
    int numKey;
    public StatesNode() {

    }

    public StatesNode(String state) {

        this.key = state;
        this.numKey = count;
        this.left = new StatesNode();
        this.right = new StatesNode();
        count++;

    }

    public String getKey(StatesNode node) {

        return key;

    }

    public int getCount() {
        return count;
    }

    public int getNumKey() {

        return numKey;
    }

}
