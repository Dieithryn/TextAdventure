package org.example;


public class StatesBinarySearchTree {

    private StatesNode root;

    public StatesBinarySearchTree() {

        root = new StatesNode();

    }

    public StatesNode insertNode(String stateName, int numKey){

        return insertNode(new StatesNode(stateName, numKey), numKey);

    }
    private StatesNode insertNode(StatesNode newNode, int index) {


        if (this.root == null) {

            this.root = newNode;

        }else if (index < (newNode.getNumKey())) {

            this.root.left = insertNode(this.root.left, index);

        } else if (index > (newNode.getNumKey())) {

            this.root.right = insertNode(this.root.right, index);

        }

        return root;

    }
    public StatesNode search(int numKey) {
        return search(root, numKey);
    }
    private StatesNode search(StatesNode rootNode, int numKey) {
        if (rootNode == null) {
            return null;
        }
        if (rootNode.getNumKey() == numKey) {
            return root;
        }
        if (rootNode.getNumKey() > numKey) {
            return search(rootNode.left, numKey);
        } else {
            return search(rootNode.right, numKey);
        }
    }
}
