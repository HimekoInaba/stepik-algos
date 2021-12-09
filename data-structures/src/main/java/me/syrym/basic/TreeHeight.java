package me.syrym.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Input. Root tree with nodes {0, . . . , n−1}, given
 * as sequence parent0, . . . , parentn−1, where parenti —
 * is parent of i-th node.
 * Output. Height of the tree.
 */
public class TreeHeight {
    public static void main(String[] args) {
        new TreeHeight().solve();
    }

    private void solve() {
        FastScanner fastScanner = new FastScanner();
        int n = fastScanner.nextInt();
        int rootIdx = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int childIdx = 0; childIdx < n; childIdx++) {
            int parentIdx = fastScanner.nextInt();
            List<Integer> list = map.getOrDefault(parentIdx, new ArrayList<>());
            list.add(childIdx);
            map.put(parentIdx, list);
            if (parentIdx == -1) {
                rootIdx = childIdx;
            }
        }
        System.out.println(getHeight(map, rootIdx));
    }

    private int getHeight(Map<Integer, List<Integer>> map, int i) {
        if (i == -1) {
            return 0;
        }
        int height = 1;
        if (map.containsKey(i)) {
            for (int childIdx : map.get(i)) {
                height = Math.max(height, 1 + getHeight(map, childIdx));
            }
        }
        return height;
    }

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    System.out.println("IO ERROR: " + e.getMessage());
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "ERROR!";
            }
        }
    }
}
