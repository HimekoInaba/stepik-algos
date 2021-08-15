package me.syrym.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DifferentAugends {
    public static void main(String[] args) {
        int n = new FastScanner().nextInt();
        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
        }
        if (n == 2) {
            System.out.println(2);
            System.out.println(2);
        }
        List<Integer> list = new ArrayList<>();
        int prev = 0;
        int till = n;
        for (int i = 1; i < till; i++) {
            if (n - i > prev + 1 || n - i == 0) {
                list.add(i);
                n -= i;
                prev = i;
            }
        }
        System.out.println(list.size());
        list.forEach(it -> System.out.print(it + " "));
    }

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    System.out.println("IO ERROR: " + e.getMessage());
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "ERROR!";
            }
        }
    }
}
