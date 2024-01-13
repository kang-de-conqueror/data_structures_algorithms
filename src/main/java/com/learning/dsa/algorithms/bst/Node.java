package com.learning.dsa.algorithms.bst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int key;
    private Node left;
    private Node right;

    public Node(int item) {
        this.key = item;
        this.left = this.right = null;
    }
}
