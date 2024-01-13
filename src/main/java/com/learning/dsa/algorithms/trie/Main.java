package com.learning.dsa.algorithms.trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("the");
        trie.addWord("then");
        trie.addWord("bigo");
        trie.printWords();
        System.out.println(trie.findWord("there"));
        System.out.println(trie.findWord("th"));
        System.out.println(trie.findWord("the"));
        trie.removeWord("bigo");
        trie.removeWord("the");
        trie.removeWord("then");
    }
}
