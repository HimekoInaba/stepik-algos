package me.syrym.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CoverLineSegmentsWithPoints {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int f = scanner.nextInt();
            int s = scanner.nextInt();
            list.add(new int[]{f,s});
        }
        list.sort((o1, o2) -> o1[1] - o2[1]);

        List<Integer> res = new ArrayList<>();
        int lim = list.get(0)[1];
        res.add(lim);
        for (int i = 1; i < list.size(); i++) {
            int[] pair = list.get(i);
            if (lim >= pair[0] && lim <= pair[1]) {
                continue;
            } else {
                lim = pair[1];
                res.add(lim);
            }
        }
        System.out.println(res.size());
        for (Integer as: res) {
            System.out.print(as + " ");
        }
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
