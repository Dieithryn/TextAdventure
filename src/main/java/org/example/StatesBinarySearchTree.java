package org.example;


import java.text.Collator;
import java.util.Locale;

public class StatesBinarySearchTree {

    protected StatesNode root;

    private final Collator usCollator = Collator.getInstance(Locale.US);


    public StatesBinarySearchTree() {

        this.root = null;

    }
    public StatesNode insertNode(String stateName) {

        return insertNode(this.root, stateName);

    }
    private StatesNode insertNode(StatesNode root, String stateName) {

        usCollator.setStrength(Collator.PRIMARY);

        //insertion logic
        if (root == null) {

            root = new StatesNode(stateName);
            return root;
        }
        if (usCollator.compare(stateName, root.getKey()) < 0) {

            root.left = insertNode(root.left, stateName);

        } else if (usCollator.compare(stateName, root.getKey()) > 0) {

            root.right = insertNode(root.right, stateName);

        } else {
            return root;
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);


        // auto-balancing logic
        if (balance > 1 && usCollator.compare(stateName, root.getKey()) < 0) {
            return rightRotate(root);

        }
        if (balance < -1 && usCollator.compare(stateName, root.getKey()) > 0) {
            return leftRotate(root);
        }
        if (balance > 1 && usCollator.compare(stateName, root.getKey()) > 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && usCollator.compare(stateName, root.getKey()) < 0) {
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

    public StatesNode searchForNode(String stateName) {
        return searchForNode(this.root, stateName);
    }
    private StatesNode searchForNode(StatesNode rootNode, String key) {

        usCollator.setStrength(Collator.PRIMARY);

        if (rootNode == null || usCollator.compare(key, rootNode.getKey()) == 0) {

            return rootNode;
        }
        if (usCollator.compare(key, rootNode.getKey()) < 0) {
            return searchForNode(rootNode.left, key);
        } else {
            return searchForNode(rootNode.right, key);
        }
    }


}
