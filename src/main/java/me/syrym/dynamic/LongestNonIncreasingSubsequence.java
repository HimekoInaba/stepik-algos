package me.syrym.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestNonIncreasingSubsequence {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        /*
        7
        5 3 4 4 2 5 9
        answ:
        4
        1 3 4 5
         */
        LNISBottomUpNLogN(arr);
    }

    // n ^ 2 is too slow for n = 10^5!
    static void LNISBottomUp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        int prev = -1;
        for (int i = 0; i < dp.length; i++) {
            if (res < dp[i]) {
                res = dp[i];
                prev = i;
            }
        }

        System.out.println(res);
        int[] result = new int[res];
        int start = prev;
        result[res - 1] = prev + 1;
        int k = res - 2;
        for (int i = start; i >= 0 && res != 0; i--) {
            if (dp[i] == dp[prev] - 1) {
                result[k--] = i + 1;
                prev = i;
                res--;
            }
        }
        for (int a : result) {
            System.out.print(a + " ");
        }
    }

    static void LNISBottomUpNLogN(int[] arr) {
        int[] dp = new int[arr.length + 1];
        int[] pos = new int[arr.length + 1];
        int[] prev = new int[arr.length];
        int length = 0;
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = Integer.MAX_VALUE;

        // dp[i] = число на которое заканчивается невозрастающая подпоследовательность длины i
        // dp[i-1] >= dp[i]
        // 5 3 4 4 2 5 9
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (dp[j - 1] >= arr[i] && arr[i] > dp[j]) {
                    dp[j] = arr[i];
                    pos[j] = i;
                    prev[i] = pos[j - 1];
                    length = Math.max(length, j);
                }
            }
        }

        System.out.println(length);
        List<Integer> res = new ArrayList<>();
        int p = pos[length];
        while (p != Integer.MAX_VALUE) {
            res.add(arr[p]);
            p = prev[p];
        }
        Collections.reverse(res);
        res.forEach(it -> System.out.print(it + " "));
    }

    static void LIS(int[] arr) {
        int d[] = new int[arr.length + 1];
        d[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= arr.length; ++i)
            d[i] = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j <= arr.length; j++)
                if (d[j - 1] < arr[i] && arr[i] < d[j])
                    d[j] = arr[i];
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
    }
}
