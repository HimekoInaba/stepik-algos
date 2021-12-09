package me.syrym.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GiantFib {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        long m = fs.nextLong();
        long prev = 0L;
        long curr = 1L;
        long period = 1;
        for (long i = 1; i <= m * m; i++) {
            long next = (prev % m + curr % m) % m;
            if (next == 1 && curr == 0) {
                period = i;
                break;
            }
            prev = curr;
            curr = next;
        }

        long remainder = n % period;
        long first = 0L;
        long second = 1L;
        long result = remainder;
        for (int i = 1; i < remainder; i++) {
            result = (first + second) %  m;
            first = second;
            second = result;
        }

        System.out.println(result % m);
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
