package me.syrym.greedy.huffman;

import me.syrym.greedy.FastScanner;
import me.syrym.greedy.huffman.structure.Leaf;
import me.syrym.greedy.huffman.structure.Node;
import me.syrym.greedy.huffman.structure.Parent;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncoding extends FastScanner {
    // abacabad
    public static void main(String[] args) {
        String input = new FastScanner().readLine();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Map<Character, Node> nodeMap = new HashMap<>();
        frequencyMap.forEach((key, value) -> {
            Node node = new Leaf(key, value);
            priorityQueue.add(node);
            nodeMap.put(key, node);
        });

        if (priorityQueue.size() == 1) {
            Node first = priorityQueue.poll();
            System.out.println(nodeMap.size() + " " + nodeMap.get(input.charAt(0)).sum);
            first.buildCode("0");
        } else {
            int sum = 0;
            while (priorityQueue.size() > 1) {
                Node first = priorityQueue.poll();
                Node second = priorityQueue.poll();
                Parent parent = new Parent(first, second);
                sum += parent.sum;
                priorityQueue.add(parent);
            }
            Node root = priorityQueue.poll();
            System.out.println(nodeMap.size() + " " + sum);
            root.buildCode("");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(nodeMap.get(c).code);
        }

        System.out.println(sb);
    }
}