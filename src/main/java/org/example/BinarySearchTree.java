package org.example;


import java.text.Collator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class BinarySearchTree {

    protected Node root;
    protected Queue<Node> queue;
    private final Collator usCollator = Collator.getInstance(Locale.US);


    public BinarySearchTree() {

        this.root = null;

    }
    public Node insertNode(String stateName, String stateText, BinarySearchTree commandTree) {

        return insertNode(this.root, stateName, stateText, commandTree);

    }
    private Node insertNode(Node root, String stateName, String stateText, BinarySearchTree commandTree) {

        usCollator.setStrength(Collator.PRIMARY);

        //insertion logic
        if (root == null && commandTree == null) {

            root = new Node(stateName, stateText);
            return root;

        } else if (root == null && commandTree != null){

            root = new StatesNode(stateName, stateText, commandTree);
            return root;
        }

        if (usCollator.compare(stateName, root.getKey()) < 0) {

            root.left = insertNode(root.left, stateName, stateText, commandTree);

        } else if (usCollator.compare(stateName, root.getKey()) > 0) {

            root.right = insertNode(root.right, stateName, stateText, commandTree);

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
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private Node rightRotate(Node nodeOne) {
        Node nodeTwo = nodeOne.left;
        Node nodeThree = nodeTwo.right;

        nodeTwo.right = nodeOne;
        nodeOne.left = nodeThree;

        nodeOne.height = Math.max(getHeight(nodeOne.left), getHeight(nodeOne.right)) + 1;
        nodeTwo.height = Math.max(getHeight(nodeTwo.left), getHeight(nodeTwo.right)) + 1;

        return nodeTwo;
    }

    private Node leftRotate(Node nodeOne) {
        Node nodeTwo = nodeOne.right;
        Node nodeThree = nodeTwo.left;

        nodeTwo.left = nodeOne;
        nodeOne.right = nodeThree;

        nodeOne.height = Math.max(getHeight(nodeOne.left), getHeight(nodeOne.right)) + 1;
        nodeTwo.height = Math.max(getHeight(nodeTwo.left), getHeight(nodeTwo.right)) + 1;

        return nodeTwo;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    public Node searchForNode(String stateName) {
        return searchForNode(this.root, stateName);
    }
    private Node searchForNode(Node rootNode, String key) {

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

    public Queue<Node> searchAll() {

        queue = new LinkedList<>();
        queue.add(root);

        return searchAll(this.root, queue);

    }

    private Queue<Node> searchAll(Node root, Queue<Node> queue) {


                if (root.left != null) {

                    queue.add(root.left);
                    searchAll(root.left, queue);

                }
                if (root.right != null) {

                    queue.add(root.right);
                    searchAll(root.right, queue);

                }


            return queue;


    }


}
