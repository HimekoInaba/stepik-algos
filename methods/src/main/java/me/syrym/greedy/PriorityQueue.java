package me.syrym.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PriorityQueue {
    private final int[] table = new int[100000 + 1];
    private int tailIdx;

    public static void main(String[] args) {
        new PriorityQueue().solve();
    }

    private void solve() {
        Arrays.fill(table, -1);
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String[] ins = scanner.readLine().split(" ");
            String command = ins[0];
            switch (command) {
                case "Insert":
                    insert(Integer.parseInt(ins[1]));
                    break;
                case "ExtractMax":
                    System.out.println(extractMax());
                    break;
            }
        }
    }

    private void insert(int element) {
        table[++tailIdx] = element;
        trickleUp(tailIdx);
    }

    private void trickleUp(int idx) {
        if (idx == 1) {
            return;
        }

        int parentIdx = idx / 2;
        if (table[idx] > table[parentIdx]) {
            swap(idx, parentIdx);
            trickleUp(parentIdx);
        }
    }

    private int extractMax() {
        int result = table[1];
        table[1] = -1;
        swap(1, tailIdx--);
        trickleDown(1);
        return result;
    }

    private void trickleDown(int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;

        if (left == tailIdx && table[left] > table[idx]) {
            swap(left, idx);
            return;
        }

        if (right == tailIdx && table[right] > table[idx]) {
            swap(table[left] > table[right] ? left : right, idx);
            return;
        }

        if (right > tailIdx || left > tailIdx) {
            return;
        }

        if (table[left] > table[right] && table[left] > table[idx]) {
            swap(left, idx);
            trickleDown(left);
        } else if (table[right] > table[idx]) {
            swap(right, idx);
            trickleDown(right);
        }
    }

    private void swap(int i, int j) {
        int tmp = table[i];
        table[i] = table[j];
        table[j] = tmp;
    }

    private static class FastScanner {
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
