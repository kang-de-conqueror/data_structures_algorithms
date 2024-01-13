package com.learning.dsa.algorithms.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
  private Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public Node createNode(int x) {
    return new Node(x);
  }

  public void insertNode(int x) {
    root = insertNode(root, x);
  }

  private Node insertNode(Node root, int x) {
    if (root == null) {
      return createNode(x);
    }
    if (x < root.getKey()) {
      root.setLeft(insertNode(root.getLeft(), x));
    } else if (x > root.getKey()) {
      root.setRight(insertNode(root.getRight(), x));
    }
    return root;
  }

  public void createTree(int a[]) {
    this.root = null;
    for (int i = 0; i < a.length; i++) {
      root = insertNode(root, a[i]);
    }
  }

  public void createTree(List<Integer> a) {
    this.root = null;
    for (int i = 0; i < a.size(); i++) {
      root = insertNode(root, a.get(i));
    }
  }

  public Node searchNode(int x) {
    return searchNode(root, x);
  }

  private Node searchNode(Node root, int x) {
    if (root == null || root.getKey() == x) {
      return root;
    }
    if (root.getKey() < x) {
      return searchNode(root.getRight(), x);
    }
    return searchNode(root.getLeft(), x);
  }

  public void deleteNode(int x) {
    root = deleteNode(root, x);
  }

  private Node deleteNode(Node root, int x) {
    if (root == null) return root;
    if (x < root.getKey()) {
      root.setLeft(deleteNode(root.getLeft(), x));
    } else if (x > root.getKey()) {
      root.setRight(deleteNode(root.getRight(), x));
    } else {
      if (null == root.getLeft()) {
        Node temp = root.getRight();
        root = null;
        return temp;
      } else if (null == root.getRight()) {
        Node temp = root.getLeft();
        root = null;
        return temp;
      }
      Node temp = minValueNode(root.getRight());
      root.setKey(temp.getKey());
      root.setRight(deleteNode(root.getRight(), temp.getKey()));
    }
    return root;
  }

  private Node minValueNode(Node node) {
    Node current = node;
    while (null != current.getLeft()) {
      current = current.getLeft();
    }
    return current;
  }

  public void preorderTraversalTree() {
    preorderTraversalTree(root);
  }

  private void preorderTraversalTree(Node root) {
    if (root != null) {
      preorderTraversalTree(root.getLeft());
      System.out.println(root.getKey() + "\t");
      preorderTraversalTree(root.getRight());
    }
  }

  public int height() {
    return height(root);
  }

  private int height(Node root) {
    if (root == null) return 0;
    return height(root.getLeft()) + height(root.getRight()) + 1;
  }

  public void deleteTree() {
    deleteTree(root);
  }

  private void deleteTree(Node root) {
    if (root == null) return;
    deleteTree(root.getLeft());
    deleteTree(root.getRight());
    root = null;
  }

  public int sumValues() {
    if (root == null) return 0;
    int sum = 0;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node node = q.remove();
      sum += node.getKey();
      if (node.getLeft() != null) q.add(node.getLeft());
      if (node.getRight() != null) q.add(node.getRight());
    }
    return sum;
  }
}
