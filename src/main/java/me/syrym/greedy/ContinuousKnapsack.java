package me.syrym.greedy;

import me.syrym.FastScanner;

import java.util.ArrayList;
import java.util.List;

public class ContinuousKnapsack extends FastScanner {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        double n = scanner.nextDouble();
        double w = scanner.nextDouble();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double cost = scanner.nextDouble();
            double weight = scanner.nextDouble();
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
}
