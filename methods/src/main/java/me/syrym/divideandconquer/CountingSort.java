package me.syrym.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingSort {
    public static void main(String[] args) {
        new CountingSort().solve();
    }

    private void solve() {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] arr = new int[11];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()]++;
        }
        for (int i = 0; i < 11; i++) {
            int num = arr[i];
            while (num > 0) {
                System.out.print(i + " ");
                num--;
            }
        }
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
