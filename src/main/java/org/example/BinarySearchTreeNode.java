package org.example;

public abstract class BinarySearchTreeNode<T> {


        BinarySearchTreeNode<T> left;
        BinarySearchTreeNode<T> right;
        T key;

        BinarySearchTreeNode() {

                this.key = null;
                this.left = null;
                this.right = null;

        }

        T getKey() {
                return key;
        }
        BinarySearchTreeNode<T> getLeft() {
                return left;
        }
        BinarySearchTreeNode<T> getRight() {
                return right;
        }
}
