package Week15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class reviewNormalKruskal {
    static int[] size;
    static int[] trace;

    static int find(int u) {
        if (u == trace[u]) return u;
        return find(trace[u]);
    }

    static boolean union(int u, int v) {
        u = trace[u];
        v = trace[v];
        if (u == v) return false;
        if (size[u] < size[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        trace[v] = trace[u];
        size[u] += size[v];
        return true;
    }

    static List<edge> kruskal(List<edge> e, int n, int m) {
        Collections.sort(e);
        List<edge> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (res.size() == n - 1) break;
            edge cur = e.get(i);
            if (union(cur.u, cur.v)) res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        trace = new int[n + 1];
        size = new int[n + 1];
        List<edge> e = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            trace[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            e.add(new edge(u, v, w));
        }
        List<edge> res = kruskal(e, n, m);
        for (edge x : res) x.in();
    }

    static class edge implements Comparable<edge> {
        int u, v, w;

        edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(edge o) {
            if (w > o.w) return 1;
            else if (w < o.w) return -1;
            else return 0;
        }

        void in() {
            System.out.println("canh: " + u + " " + v + ", " + w);
        }
    }
}
