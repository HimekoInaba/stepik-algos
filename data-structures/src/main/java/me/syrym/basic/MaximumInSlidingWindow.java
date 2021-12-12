package me.syrym.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumInSlidingWindow {
    public static void main(String[] args) {
        new MaximumInSlidingWindow().solve();
    }

    private void solve() {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        MaxQueue maxQueue = new MaxQueue(m);
        for (int elem : arr) {
            maxQueue.push(elem);
        }
    }

    static class MaxQueue {
        private final int size;
        private final MaxStack firstStack = new MaxStack();
        private final MaxStack secondStack = new MaxStack();

        MaxQueue(int size) {
            this.size = size;
        }

        void push(int val) {
            if (firstStack.getSize() + secondStack.getSize() == size) {
                if (secondStack.getSize() == 0) {
                    while (firstStack.getSize() != 0) {
                        secondStack.push(firstStack.pop());
                    }
                }
                secondStack.pop();
            }

            firstStack.push(val);

            if (firstStack.getSize() + secondStack.getSize() == size) {
                System.out.println(Math.max(firstStack.max(), secondStack.max()));
            }
        }
    }

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    System.out.println("IO ERROR: " + e.getMessage());
                }
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
