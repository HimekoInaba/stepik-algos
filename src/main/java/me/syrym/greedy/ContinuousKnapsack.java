package me.syrym.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ContinuousKnapsack {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        double n = scanner.nexDouble();
        double w = scanner.nexDouble();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double cost = scanner.nexDouble();
            double weight = scanner.nexDouble();
            if (cost != 0)
                items.add(new Item(cost, weight));
        }

        items.sort((o1, o2) -> {
            double diff = (o1.cost / o1.weight) - (o2.cost / o2.weight);
            if (diff == 0) {
                return o2.weight > o1.weight ? 1 : -1;
            }
            return diff > 0 ? -1 : 1;
        });
        int i = 0;
        double answ = 0.0;
        while (w > 0 && i < items.size()) {
            Item curr = items.get(i);
            if (curr.weight > w) {
                double smh = curr.cost / curr.weight;
                answ += (w * smh);
                w = 0;
            } else {
                answ += curr.cost;
                w -= curr.weight;
            }
            i++;
        }
        System.out.println(answ);
    }

    static class Item {
        double weight;
        double cost;

        Item(double cost, double weight) {
            this.weight = weight;
            this.cost = cost;
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

        double nexDouble() {
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
