package org.example;

public class StatesNode extends BinarySearchTreeNode<String> {

    protected StatesNode left;
    protected StatesNode right;
    protected String key;
    protected int count;
    protected int numKey;

    public StatesNode() {

    }

    public StatesNode(int numKey) {

        this.numKey = numKey;
        this.left = null;
        this.right = null;

    }

    public void setCount(int count) {

        this.count = count;

    }
    public void setKey(String key) {
        this.key = key;
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
