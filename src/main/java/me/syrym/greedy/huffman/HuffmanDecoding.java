package me.syrym.greedy.huffman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HuffmanDecoding {
    private String code;

    public static void main(String[] args) {
        new HuffmanDecoding().solve();
    }

    void solve() {
        FastScanner fastScanner = new FastScanner();
        int k = fastScanner.nextInt();
        int l = fastScanner.nextInt();

        Map<String, String> frequencyMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String line = fastScanner.readLine();
            frequencyMap.put(
                    line.substring(3),
                    Character.toString(line.charAt(0))
            );
        }
        String line = fastScanner.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            String curr = "";
            curr += line.charAt(i);
            while (!frequencyMap.containsKey(curr) && i+1 < line.length()) {
                curr += line.charAt(++i);
            }
            sb.append(frequencyMap.get(curr));
        }
        System.out.println(sb);
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
