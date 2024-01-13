package com.learning.dsa.algorithms.bellmanford;

public class Edge {
    private int source;
    private int target;
    private int weight;

    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public int getSource() {
        return this.source;
    }

    public int getTarget() {
        return this.target;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
