package com.learning.dsa.algorithms.trie;

public class Node {
    private static final int MAX = 26;
    private Node[] child;
    private int countWord;

    public Node() {
        this.countWord = 0;
        child = new Node[MAX];
    }

    public Node[] getChild() {
        return this.child;
    }

    public void setChild(Node[] child) {
        this.child = child;
    }

    public int getCountWord() {
        return this.countWord;
    }

    public void setCountWord(int countWord) {
        this.countWord = countWord;
    }
}
