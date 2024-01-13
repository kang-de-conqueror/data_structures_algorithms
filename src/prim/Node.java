package prim;

public class Node implements Comparable<Node> {
    private Integer id;
    private Integer dist;

    public Integer getId() {
        return this.id;
    }

    public Integer getDist() {
        return this.dist;
    }

    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist.compareTo(o.getDist());
    }
}
