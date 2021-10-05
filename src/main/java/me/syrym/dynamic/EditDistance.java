package me.syrym.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EditDistance {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String a = fs.next();
        String b = fs.next();
        System.out.println(distance(a, b));
    }

    private static int distance(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] d = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            d[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            d[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int insert = d[i][j - 1] + 1;
                int delete = d[i - 1][j] + 1;
                int diff = a.charAt(i - 1) == b.charAt(j - 1) ? d[i - 1][j - 1] : d[i - 1][j - 1] + 1;
                d[i][j] = Math.min(
                        Math.min(insert, delete),
                        diff
                );
            }
        }

        return d[n][m];
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
