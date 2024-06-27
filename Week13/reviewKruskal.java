package Week13;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class reviewKruskal {
    static int[] trace;
    static int[] sizeOfRoot;

    static int find(int u) {
        if (u == trace[u]) return u;
        return find(trace[u]);
    }

    static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return false;
        if (sizeOfRoot[u] < sizeOfRoot[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        trace[v] = trace[u];
        sizeOfRoot[u] += sizeOfRoot[v];
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<edge>> adj = new ArrayList<>();
        trace = new int[n + 1];
        sizeOfRoot = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj.add(new ArrayList<>());
            trace[i] = i;
            sizeOfRoot[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u - 1).add(new edge(u, v, w));
            adj.get(v - 1).add(new edge(v, u, w));
        }
        List<edge> res = new ArrayList<>();
        int sum = 0;
        int start = sc.nextInt();
        PriorityQueue<edge> curEdges = new PriorityQueue<>();
        for (edge tmp : adj.get(start - 1)) {
            curEdges.add(tmp);
        }

        while (!curEdges.isEmpty() && res.size() < n - 1) {
            edge tmp = curEdges.poll();
            if (union(tmp.u, tmp.v)) {
                res.add(tmp);
                sum += tmp.w;
            }
        }

        System.out.println(sum);

    }

    static class edge implements Comparable<edge> {
        public int u, v, w;

        public edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(edge o) {
            if (w > o.w) return 1;
            else if (w < o.w) return -1;
            return 0;
        }
    }

}
