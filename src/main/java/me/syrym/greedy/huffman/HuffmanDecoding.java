/*
package me.syrym.greedy.huffman;

import me.syrym.FastScanner;
import me.syrym.greedy.Pair;
import me.syrym.greedy.huffman.structure.Leaf;
import me.syrym.greedy.huffman.structure.Node;
import me.syrym.greedy.huffman.structure.Parent;

import java.util.ArrayList;
import java.util.List;

public class HuffmanDecoding extends FastScanner {
    private String code;

    public static void main(String[] args) {
        new HuffmanDecoding().solve();
    }

    void solve() {
        FastScanner fastScanner = new FastScanner();
        int k = fastScanner.nextInt();
        int l = fastScanner.nextInt();

        List<Leaf> leaves = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String line = fastScanner.readLine();
            leaves.add(new Leaf(line.charAt(0), line.substring(2)));
        }
         this.code = fastScanner.readLine();

        Node prev = leaves.get(leaves.size() - 1);
        for (int i = leaves.size() - 2; i >= 0; --i) {
            prev = new Parent(leaves.get(i), prev);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < code.length()) {
            Pair<Character, Integer> res = traverse(prev, i);
            sb.append(res.left);
            i = res.right;
        }
        System.out.println(sb);
    }

    private Pair<Character, Integer> traverse(Parent node, String curr) {
        
    }
}
*/
