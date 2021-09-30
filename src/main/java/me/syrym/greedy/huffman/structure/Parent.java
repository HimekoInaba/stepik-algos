package me.syrym.greedy.huffman.structure;

public class Parent extends Node {
    public Node left;
    public Node right;

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + "0");
        right.buildCode(code + "1");
    }

    public Parent(Node left, Node right) {
        super(left.sum + right.sum);
        this.left = left;
        this.right = right;
    }
}
