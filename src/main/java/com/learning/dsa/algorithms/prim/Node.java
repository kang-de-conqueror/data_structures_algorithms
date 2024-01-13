package com.learning.dsa.algorithms.prim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node implements Comparable<Node> {
    private Integer id;
    private Integer dist;

    @Override
    public int compareTo(Node o) {
        return this.dist.compareTo(o.getDist());
    }
}
