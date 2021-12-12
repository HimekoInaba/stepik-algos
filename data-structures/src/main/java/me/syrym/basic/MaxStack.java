package me.syrym.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxStack {
    private StackNode head = null;
    private int size = 0;

    public static void main(String[] args) {
        new MaxStack().solve();
    }

    private void solve() {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String[] elems = scanner.readLine().split(" ");
            switch (elems[0]) {
                case "push":
                    int val = Integer.parseInt(elems[1]);
                    push(val);
                    break;
                case "max":
                    System.out.println(max());
                    break;
                case "pop":
                    pop();
                    break;
            }
        }
    }

    public void push(int val) {
        if (head == null) {
            size = 1;
            head = new StackNode(val, val, null);
        } else {
            size++;
            head = new StackNode(val, Math.max(val, head.max), head);
        }
    }

    public int max() {
        if (head == null) {
            return 0;
        }
        return head.max;
    }

    public int pop() {
        if (head != null) {
            size--;
            int elem = head.val;
            head = head.prev;
            return elem;
        }
        throw new IllegalStateException("Stack is empty!");
    }

    public int getSize() {
        return this.size;
    }

    static class StackNode {
        int val;
        StackNode prev;
        int max;

        StackNode(int val, int max, StackNode prev) {
            this.val = val;
            this.max = max;
            this.prev = prev;
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
