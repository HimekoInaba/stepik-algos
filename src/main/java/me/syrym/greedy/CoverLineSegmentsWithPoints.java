package me.syrym.greedy;

import java.util.ArrayList;
import java.util.List;

public class CoverLineSegmentsWithPoints extends FastScanner {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int f = scanner.nextInt();
            int s = scanner.nextInt();
            list.add(new int[]{f, s});
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
        for (Integer as : res) {
            System.out.print(as + " ");
        }
    }
}
