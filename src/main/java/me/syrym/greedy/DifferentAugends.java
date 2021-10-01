package me.syrym.greedy;

import me.syrym.FastScanner;

import java.util.ArrayList;
import java.util.List;

public class DifferentAugends extends FastScanner {
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
}
