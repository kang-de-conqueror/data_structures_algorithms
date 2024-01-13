package com.learning.dsa.algorithms.bst;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Create the tree with given list of integers
        bst.createTree(Arrays.asList(3, 1, 5, 4, 2));

        // Calculate height of Binary Search Tree
        System.out.println(bst.height());

        // Sum all values in Binary Search Tree
        System.out.println(bst.sumValues());
    }
}
