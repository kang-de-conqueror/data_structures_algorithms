package com.learning.dsa.algorithms.heap;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Demo MinHeap
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 12, 6, 10, 17, 15, 2, 4));
        Heap.buildMinHeap(list);
        System.out.println(list);
        Heap.pushBack(list, 1);
        System.out.println(list);
        Heap.pop(list);
        System.out.println(list);
    }
}
