package me.syrym.greedy.huffman.structure;

public class Node implements Comparable<Node> {
    public int sum;
    public String code;

    public Node(int sum) {
        this.sum = sum;
    }

    public Node() {}

    public void buildCode(String code) {
        this.code = code;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(sum, o.sum);
    }
}
