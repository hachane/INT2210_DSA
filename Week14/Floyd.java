package Week14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Floyd {
    static List<edge> adj = new ArrayList<>();
    static double dist1[];

    static void bellmanford(int numVertex, int s, List<edge> adj, double[] dist) {
        for (int i = 0; i < dist.length; i++) dist[i] = Double.POSITIVE_INFINITY;
        dist[s] = 0;
        for (int i = 1; i < numVertex; i++) {
            for (edge tmp : adj) {
                int u = tmp.u;
                int v = tmp.v;
                int w = tmp.w;
                if (dist[u] != Double.POSITIVE_INFINITY && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    //System.out.println(dist[u]);
                    //System.out.println(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();
        double[] dist = new double[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.add(new edge(u, v, w));
        }
        bellmanford(n, s, adj, dist);
        for (double i : dist) System.out.println(i);
    }

    static class edge {
        int u, v, w;

        public edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
