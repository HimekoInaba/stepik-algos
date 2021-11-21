package me.syrym.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InversionCount {
    private int[] A = new int[100001];
    private int[] B = new int[100001];

    public static void main(String[] args) {
        new InversionCount().solve();
    }

    // 0 ≤ i < j < n, для которых A[i] > A[j]
    private void solve() {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(divide(arr, 0, n - 1));
    }

    private long divide(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            return divide(arr, l, mid) + divide(arr, mid + 1, r) + merge(arr, l, mid, r);
        }
        return 0;
    }

    private long merge(int[] arr, int l, int mid, int r) {
        long cnt = 0;
        int n = mid - l + 1;
        int m = r - mid;
        int k = l;
        for (int i = 0; i < n; i++) {
            A[i] = arr[k++];
        }
        k = mid + 1;
        for (int i = 0; i < m; i++) {
            B[i] = arr[k++];
        }

        int iter = l, i = 0, j = 0;
        while (i < n && j < m) {
            if (A[i] <= B[j]) {
                arr[iter++] = A[i++];
            } else{
                arr[iter++] = B[j++];
                cnt += n - i;
            }
        }
        while (i < n) {
            arr[iter++] = A[i++];
        }
        while (j < m) {
            arr[iter++] = B[j++];
        }
        return cnt;
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
