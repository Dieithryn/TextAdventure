package org.example;

public abstract class BinarySearchTreeNode<T> {


        BinarySearchTreeNode<T> left;
        BinarySearchTreeNode<T> right;
        T key;
        T count;

        BinarySearchTreeNode() {


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
