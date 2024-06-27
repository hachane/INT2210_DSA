package Week12;

import java.util.*;

public class BFS {
    public static int[] ans(int n, int m, List<Edge> e, int startVertex) {
        Queue<Integer> wait = new LinkedList<>();
        List<List<Edge>> adjList = new ArrayList<>();
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            if (i != startVertex) res[i] = -1;
        }
        for (Edge tmp : e) {
            adjList.get(tmp.u - 1).add(new Edge(tmp.u, tmp.v));
            adjList.get(tmp.v - 1).add(new Edge(tmp.v, tmp.u));
        }
        int unit_cost = 6;
        int cur_lvl = 1;
        int num_cur_lvl = adjList.get(startVertex - 1).size();
        boolean marked[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) marked[i] = false;
        marked[startVertex] = true;
        for (Edge tmp : adjList.get(startVertex - 1)) {
            wait.add(tmp.v);
            marked[tmp.v] = true;
        }
        while (!wait.isEmpty()) {
            int tmp = 0;
            while (tmp < num_cur_lvl) {
                int cur_ver = wait.poll();
                res[cur_ver] = cur_lvl * unit_cost;
                for (Edge t : adjList.get(cur_ver - 1)) {
                    if (marked[t.v] == false) {
                        marked[t.v] = true;
                        wait.add(t.v);
                    }
                }
                tmp++;
            }
            num_cur_lvl = wait.size();
            cur_lvl++;
        }
        for (int i = 0; i <= n; i++) {
            if (res[i] == 0 && i != startVertex) res[i] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), m = sc.nextInt();
            List<Edge> edge = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                edge.add(new Edge(sc.nextInt(), sc.nextInt()));
            }
            int startVertex = sc.nextInt();
            int[] res = ans(n, m, edge, startVertex);
            for (int i = 1; i <= n; i++) {
                if (res[i] != 0)
                    System.out.print(res[i] + " ");
            }
            System.out.print("\n");
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int u, v, w;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            if (w > o.w) return 1;
            else if (w < o.w) return -1;
            return 0;
        }
    }
}
