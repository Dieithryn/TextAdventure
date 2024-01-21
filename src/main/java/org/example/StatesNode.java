package org.example;

public class StatesNode extends BinarySearchTreeNode<String> {

    protected StatesNode left;
    protected StatesNode right;
    protected String key;
    protected int count;
    protected int height;

    public StatesNode() {

    }

    public StatesNode(String stateName) {

        this.key = stateName;
        this.height = 1;
        this.left = null;
        this.right = null;

    }
    @Override
    public String getKey() {

        return key;

    }



}
