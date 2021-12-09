package me.syrym.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder {
    public static void main(String[] args) {
        new Ladder().solve();
    }

    private void solve() {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        int prev = arr[0];
        int curr = Math.max(arr[0] + arr[1], arr[1]);
        for (int i = 2; i < n; i++) {
            int tmp = arr[i] + Math.max(prev, curr);
            prev = curr;
            curr = tmp;
        }
        System.out.println(curr);
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
