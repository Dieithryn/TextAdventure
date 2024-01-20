package org.example;



public class StatesBinarySearchTree {

    protected StatesNode root;

    public StatesBinarySearchTree() {

        this.root = null;

    }
    public StatesNode insertNode(String stateName, int numKey) {

        return insertNode(this.root, stateName, numKey);

    }
    private StatesNode insertNode(StatesNode root, String stateName, int index) {


        //insertion logic
        if (root == null) {

            root = new StatesNode(stateName, index);
            return root;
        }
        if (index < (root.getNumKey())) {

            root.left = insertNode(root.left, stateName, index);

        } else if (index >= (root.getNumKey())) {

            root.right = insertNode(root.right, stateName, index);

        } else {
            return root;
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);


        // auto-balancing logic
        if (balance > 1 && index < root.left.getNumKey()) {
            return rightRotate(root);

        }
        if (balance < -1 && index > root.right.getNumKey()) {
            return leftRotate(root);
        }
        if (balance > 1 && index > root.left.getNumKey()) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && index < root.right.getNumKey()) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }
    private int getHeight(StatesNode node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private StatesNode rightRotate(StatesNode nodeOne) {
        StatesNode nodeTwo = nodeOne.left;
        StatesNode nodeThree = nodeTwo.right;

        nodeTwo.right = nodeOne;
        nodeOne.left = nodeThree;

        nodeOne.height = Math.max(getHeight(nodeOne.left), getHeight(nodeOne.right)) + 1;
        nodeTwo.height = Math.max(getHeight(nodeTwo.left), getHeight(nodeTwo.right)) + 1;

        return nodeTwo;
    }

    private StatesNode leftRotate(StatesNode nodeOne) {
        StatesNode nodeTwo = nodeOne.right;
        StatesNode nodeThree = nodeTwo.left;

        nodeTwo.left = nodeOne;
        nodeOne.right = nodeThree;

        nodeOne.height = Math.max(getHeight(nodeOne.left), getHeight(nodeOne.right)) + 1;
        nodeTwo.height = Math.max(getHeight(nodeTwo.left), getHeight(nodeTwo.right)) + 1;

        return nodeTwo;
    }

    private int getBalance(StatesNode node) {
        if (node == null)
            return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    public StatesNode searchForNode(int numKey) {
        return searchForNode(this.root, numKey);
    }
    private StatesNode searchForNode(StatesNode rootNode, int numKey) {

        if (rootNode == null || rootNode.getNumKey() == numKey) {

            return rootNode;

        }
        if (rootNode.getNumKey() > numKey) {
            return searchForNode(rootNode.left, numKey);
        } else {
            return searchForNode(rootNode.right, numKey);
        }
    }


}
