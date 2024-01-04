package org.example;

import java.util.Objects;

public class StatesBinarySearchTree {

    private StatesNode root;
    private StatesNode newNode;

    public StatesBinarySearchTree() {

        this.root = new StatesNode("StateStart");

    }

    public void insertNode(String state) {

        this.newNode = this.root;

        if (this.newNode != null) {
            if (this.newNode.left == null) {

                this.newNode = this.newNode.left;

            } else if (this.newNode.right == null) {

                this.newNode = this.newNode.right;

            }
        }

        if (this.newNode == null) {

            newNode = new StatesNode(state);

            if (this.newNode != null) {

                newNode = this.root;

            }
        }


    }

}
