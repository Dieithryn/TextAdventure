package org.example;


public class StatesBinarySearchTree {

    protected StatesNode root;

    public StatesBinarySearchTree() {

        this.root = null;

    }

    public StatesNode insertNode(int numKey) {

        return insertNode(this.root, numKey);

    }
    private StatesNode insertNode(StatesNode root, int index) {


        if (root == null) {

            root = new StatesNode(index);
            return root;
        }
        if (index < (root.getNumKey())) {

            root.left = insertNode(root.left, index);

        } else if (index >= (root.getNumKey())) {

            root.right = insertNode(root.right, index);

        }

        return root;

    }

    public StatesNode search(int numKey) {
        return search(this.root, numKey);
    }
    private StatesNode search(StatesNode rootNode, int numKey) {
        if (rootNode == null || rootNode.getNumKey() == numKey) {

            return rootNode;

        }
        if (rootNode.getNumKey() > numKey) {
            return search(rootNode.left, numKey);
        } else {
            return search(rootNode.right, numKey);
        }
    }
}
