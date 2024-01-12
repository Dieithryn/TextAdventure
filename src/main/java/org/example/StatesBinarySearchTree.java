package org.example;


public class StatesBinarySearchTree {

    private StatesNode root;

    public StatesBinarySearchTree() {

        root = new StatesNode();

    }

    public StatesNode insertNode(StatesNode newNode, int index) {

        if (this.root == null) {

            newNode = new StatesNode(newNode.key);
            this.root = newNode;

        }
        if (index < (root.getNumKey())) {

            this.root.left = insertNode(this.root.left, index);

        } else if (index > (root.getNumKey())) {

            this.root.right = insertNode(this.root.right, index);

        }

        return root;

    }
    public StatesNode search (int numKey) {
        return search(root, numKey);
    }
    private StatesNode search(StatesNode rootNode, int numKey) {
        if (root == null) {
            return null;
        }
        if (root.getNumKey() == numKey) {
            return root;
        }
        if (root.getNumKey() > numKey) {
            return search(root.left, numKey);
        } else {
            return search(root.right, numKey);
        }
    }
}
