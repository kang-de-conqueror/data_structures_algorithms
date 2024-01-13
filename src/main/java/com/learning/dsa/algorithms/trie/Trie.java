package com.learning.dsa.algorithms.trie;

public class Trie {
    public static final int MAX = 26;
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void addWord(String s) {
        int ch;
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if (temp.getChild()[ch] == null) {
                Node x = new Node();
                temp.getChild()[ch] = x;
            }
            temp = temp.getChild()[ch];
        }
        temp.setCountWord(temp.getCountWord() + 1);
    }

    public boolean findWord(String s) {
        int ch;
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if (temp.getChild()[ch] == null) {
                return false;
            }
            temp = temp.getChild()[ch];
        }
        return temp.getCountWord() > 0;
    }

    private boolean isWord(Node node) {
        return node.getCountWord() != 0;
    }

    private boolean isEmpty(Node node) {
        for (int i = 0; i < MAX; i++) {
            if (node.getChild()[i] != null) return false;
        }
        return true;
    }

    public boolean removeWord(String s) {
        return removeWord(root, s, 0, s.length());
    }

    private boolean removeWord(Node root, String s, int level, int len) {
        if (root == null) return false;
        if (level == len) {
            if (root.getCountWord() > 0) {
                root.setCountWord(root.getCountWord() - 1);
                return true;
            }
            return false;
        }
        int ch = s.charAt(level) - 'a';
        boolean flag = removeWord(root.getChild()[ch], s, level + 1, len);
        if (flag && !isWord(root.getChild()[ch]) && isEmpty(root.getChild()[ch])) {
            root.getChild()[ch] = null;
        }
        return flag;
    }

    public void printWords() {
        printWords(root, "");
    }

    private void printWords(Node root, String s) {
        if (isWord(root)) {
            System.out.println(s);
        }
        for (int i = 0; i < MAX; i++) {
            if (root.getChild()[i] != null) {
                printWords(root.getChild()[i], s + (char) ('a' + i));
            }
        }
    }
}
