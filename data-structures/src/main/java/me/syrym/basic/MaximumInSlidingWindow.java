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

        int sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (end - start > m) {
                sum -= arr[start++];
            }
            sum += arr[end];
            if (end - start == m) {
                System.out.println(sum);
            }
        }
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
