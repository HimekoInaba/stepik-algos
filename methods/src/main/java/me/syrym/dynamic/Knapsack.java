package me.syrym.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knapsack {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int W = fs.nextInt();
        int n = fs.nextInt();
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = fs.nextInt();
        }
        int res = maximizeWeightBottomUpWithoutRep(items, W);
        System.out.println(res);
    }

    public static int maximizeWeightBottomUpWithoutRep(int[] items, int capacity) {
        int[][] dp = new int[capacity + 1][items.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        for (int i = 0; i <= capacity; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= items.length; i++) {
            dp[0][i] = 0;
        }
        for (int w = 1; w <= capacity; w++) {
            for (int i = 0; i < items.length; i++) {
                dp[w][i + 1] = dp[w][i];
                if (w >= items[i]) {
                    dp[w][i + 1] = Math.max(dp[w][i + 1], Math.max(dp[w - items[i]][i] + items[i], dp[w][i]));
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= capacity; i++) {
            res = Math.max(res, dp[i][items.length]);
        }
        return res;
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
