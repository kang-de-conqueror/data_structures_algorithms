package com.learning.dsa.algorithms.heap;

import java.util.ArrayList;

public class Heap {
    public static void buildMinHeap(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(i, arr);
        }
    }
    public static void buildMaxHeap(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(i, arr);
        }
    }

    public static int getTop(ArrayList<Integer> arr) {
        return arr.get(0);
    }

    public static void pushBack(ArrayList<Integer> arr, int value) {
        arr.add(value);
        int i = arr.size() - 1;
        while (i > 0 && arr.get((i - 1) / 2) > arr.get(i)) {
            int temp = arr.get(i);
            arr.set(i, arr.get((i - 1) / 2));
            arr.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }

    public static void pop(ArrayList<Integer> arr) {
        if (arr.size() == 0) return;
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        minHeapify(0, arr);
    }

    private static void minHeapify(int i, ArrayList<Integer> arr) {
        int pivot = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < arr.size() && arr.get(left) < arr.get(pivot)) {
            pivot = left;
        }
        if (right < arr.size() && arr.get(right) < arr.get(pivot)) {
            pivot = right;
        }
        if (pivot != i) {
            int temp = arr.get(pivot);
            arr.set(pivot, arr.get(i));
            arr.set(i, temp);
            minHeapify(pivot, arr);
        }
    }

    private static void maxHeapify(int i, ArrayList<Integer> arr) {
        int pivot = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < arr.size() && arr.get(left) > arr.get(pivot)) {
            pivot = left;
        }
        if (right < arr.size() && arr.get(right) > arr.get(pivot)) {
            pivot = right;
        }
        if (pivot != i) {
            int temp = arr.get(pivot);
            arr.set(pivot, arr.get(i));
            arr.set(i, temp);
            maxHeapify(pivot, arr);
        }
    }
}
