package me.syrym.greedy.huffman.structure;

public class Leaf extends Node {
    public char character;

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        System.out.println(character + ": " + code);
    }

    public Leaf(char character, int count) {
        super(count);
        this.character = character;
    }

    public Leaf(char character, String code) {
        this.character = character;
        super.code = code;
    }
}
