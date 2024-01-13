package com.learning.dsa.algorithms.bellmanford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    private static final int INF = Integer.MAX_VALUE;
    private static final int MAX = 105;
    private static final int[] dist = new int[MAX], path = new int[MAX];
    private static int u, v, w;

    public static int findDistanceShortestPath(int n, int m, int start, int end, Edge[] graph) {
        if (dist[end] != INF) return dist[end];
        boolean res = bellmanFord(n, m, start, end, graph);
        if (res) {
            return dist[end];
        }
        return -INF;
    }

    public static int[] findShortestPath(int n, int m, int start, int end, Edge[] graph) {
        if (dist[end] != INF) {
            List<Integer> paths = new ArrayList<>();
            paths.add(end);
            int prev = path[end];
            while (prev != -1) {
                paths.add(prev);
                prev = path[prev];
            }
            Collections.reverse(paths);
            return paths.stream().mapToInt(i -> i).toArray();
        }
        boolean res = bellmanFord(n, m, start, end, graph);
        if (res) {
            List<Integer> paths = new ArrayList<>();
            paths.add(end);
            int prev = path[end];
            while (prev != -1) {
                paths.add(prev);
                prev = path[prev];
            }
            Collections.reverse(paths);
            return paths.stream().mapToInt(i -> i).toArray();
        }
        return null;
    }

    private static boolean bellmanFord(int n, int m, int start, int end, Edge[] graph) {
        Arrays.fill(dist, INF);
        Arrays.fill(path, -1);

        dist[start] = 0;
        for(int i = 1; i <= n - 1; i++) {
            for(int j = 0; j < m; j++) {
                u = graph[j].getSource();
                v = graph[j].getTarget();
                w = graph[j].getWeight();
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    path[v] = u;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            u = graph[i].getSource();
            v = graph[i].getTarget();
            w = graph[i].getWeight();
            if (dist[u] != INF && dist[u] + w < dist[v]) {
                return false;
            }
        }
        return true;
    }
}
