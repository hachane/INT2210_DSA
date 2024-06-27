package Week15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class reviewNormalDijkstra {
    static List<List<ver>> adj = new ArrayList<>();
    static int[] dist;

    static void dijOne(int n, int m, int s, int e) {
        for (int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<ver> wait = new PriorityQueue<>();
        //System.out.println(s);
        dist[s] = 0;
        wait.add(new ver(s, 0));
        while (!wait.isEmpty() && wait.peek().u != e) {
            ver cur = wait.poll();
            int c = cur.c, u = cur.u;
            if (c != dist[u]) continue;
            for (ver tmp : adj.get(u - 1)) {
                if (dist[tmp.u] > dist[u] + tmp.c) {
                    dist[tmp.u] = dist[u] + tmp.c;
                    wait.add(new ver(tmp.u, dist[tmp.u]));
                }
            }
        }
        if (wait.isEmpty()) {
            dist[e] = -1;
            return;
        }
        dist[e] = wait.peek().c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), m = sc.nextInt();
            adj.clear();
            dist = new int[n + 1];
            for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adj.get(u - 1).add(new ver(v, w));
                adj.get(v - 1).add(new ver(u, w));
            }
            int s = sc.nextInt();
            int e = sc.nextInt();
            dijOne(n, m, s, e);
            System.out.println(dist[e]);
        }
    }

    static class ver implements Comparable<ver> {
        int u, c;

        ver(int u, int c) {
            this.u = u;
            this.c = c;
        }

        @Override
        public int compareTo(ver o) {
            if (c > o.c) return 1;
            else if (c < o.c) return -1;
            return 0;
        }
    }
}
