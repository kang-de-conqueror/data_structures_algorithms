package com.learning.dsa.algorithms.bellmanford;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Edge[] graph = new Edge[m];
        int u, v, w;
        for(int i = 0; i < m; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            graph[i] = new Edge(u, v, w);
        }
        int start = 0, end = 4;
        int distance = BellmanFord.findDistanceShortestPath(n, m, start, end, graph);
        int[] path = BellmanFord.findShortestPath(n, m, start, end, graph);
        System.out.println(distance);
        System.out.println(Arrays.toString(path));
    }
}
