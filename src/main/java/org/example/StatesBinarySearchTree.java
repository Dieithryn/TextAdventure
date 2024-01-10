package org.example;


public class StatesBinarySearchTree {

    private StatesNode root;

    public StatesBinarySearchTree() {

        root = new StatesNode();

    }

    public StatesNode insertNode(StatesNode newNode, int index) {



        if (this.root == null) {

            newNode = new StatesNode(newNode.getKey());
            this.root = newNode;

        } else if (this.root.left == null && index < (root.getCount()/2)) {

            this.root.left = insertNode(this.root.left, index);

        } else if (this.root.right == null && index > (root.getCount()/2)) {

            this.root.right = insertNode(this.root.right, index);

        } else if (this.root.left != null && index < (root.getCount()/2)) {

            this.root.left = insertNode(this.root.left, index);

        } else if (this.root.right != null && index > (root.getCount()/2)) {

            this.root.right = insertNode(this.root.right, index);
        }

        return root;

    }

}
