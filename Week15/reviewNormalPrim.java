package Week15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class reviewNormalPrim {
    static List<edge> prim(List<List<edge>> adj, int s, int n, int m) {
        List<edge> res = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        PriorityQueue<edge> wait = new PriorityQueue<>();
        visited[s] = true;
        for (edge x : adj.get(s - 1)) wait.add(x);
        while (!wait.isEmpty() && res.size() <= n - 1) {
            edge cur = wait.poll();
            if (visited[cur.u] && visited[cur.v]) continue;
            res.add(cur);
            visited[cur.u] = true;
            visited[cur.v] = true;
            for (edge x : adj.get(cur.u - 1)) wait.add(x);
            for (edge y : adj.get(cur.v - 1)) wait.add(y);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u - 1).add(new edge(u, v, w));
            adj.get(v - 1).add(new edge(v, u, w));
        }
        int s = sc.nextInt();
        List<edge> res = prim(adj, s, n, m);
        for (edge x : res) x.in();
    }

    static class edge implements Comparable<edge> {
        int u, v, w;

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

        void in() {
            System.out.println("canh: " + u + " " + v + ", " + w);
        }
    }

}
