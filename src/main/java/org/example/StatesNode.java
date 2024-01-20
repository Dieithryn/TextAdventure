package org.example;

public class StatesNode extends BinarySearchTreeNode<String> {

    protected StatesNode left;
    protected StatesNode right;
    protected String key;
    protected int count;
    protected int height;
    protected int numKey;

    public StatesNode() {

    }

    public StatesNode(String stateName, int numKey) {

        this.key = stateName;
        this.numKey = numKey;
        this.height = 1;
        this.left = null;
        this.right = null;

    }
    @Override
    public String getKey() {

        return key;

    }

    public int getNumKey() {

        return numKey;

    }


}
