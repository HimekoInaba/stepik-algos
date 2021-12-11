package me.syrym.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NetworkPacketsSimulation {
    public static void main(String[] args) {
        new NetworkPacketsSimulation().solve();
    }

    private void solve() {
        FastScanner scanner = new FastScanner();
        int size = scanner.nextInt();
        int n = scanner.nextInt();

        FixedSizeQueue<Packet> buffer = new FixedSizeQueue<>(size);
        for (int i = 0; i < n; i++) {
            buffer.offer(new Packet(scanner.nextInt(), scanner.nextInt()));
        }
    }

    static class FixedSizeQueue<T> {
        int size = 0;
        int capacity;
        Queue<T> queue = new LinkedList<>();

        FixedSizeQueue(int capacity) {
            this.capacity = capacity;
        }

        boolean offer(T packet) {
            if (size < capacity) {
                this.queue.offer(packet);
                size++;
                return true;
            }
            return false;
        }

        T poll() {
            if (size <= 0) {
                return null;
            } else {
                size--;
                return queue.poll();
            }
        }

        boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    static class Packet {
        int arrival;
        int duration;
        Packet(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }
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
