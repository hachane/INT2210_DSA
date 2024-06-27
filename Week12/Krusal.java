package Week12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Krusal {
    public static final int MAX = 10001;
    public static int parent[] = new int[MAX], sizeOfRoot[] = new int[MAX];

    // check whether is too vertex a same root;
    public static int find(int vertex) {
        if (vertex == parent[vertex]) return vertex;
        return find(parent[vertex]);
    }

    public static boolean union(int u, int v) {
        // find if we can connect 2 vertices or not
        u = find(u);
        v = find(v);
        // if same root, can't connect
        if (u == v) return false;
        if (sizeOfRoot[u] < sizeOfRoot[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        // if not same root, connect
        parent[v] = parent[u];
        sizeOfRoot[u] += sizeOfRoot[v];
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        List<Edge> res = new ArrayList<>();
        int s = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }
        Collections.sort(edges);
        for (int i = 0; i < MAX; i++) {
            parent[i] = i;
            sizeOfRoot[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (res.size() == n - 1) break;
            Edge tmp = edges.get(i);
            // ham union check xem canh them vao co tao ra chu trinh hay khong, neu co the thi se them vao
            if (union(tmp.u, tmp.v)) {
                res.add(tmp);
                s += tmp.w;
            }
        }
        System.out.println(s);
    }

    public static class Edge implements Comparable<Edge> {
        public int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            if (o.w > w) return -1;
            else if (o.w < w) return 1;
            return 0;
        }

        public void in() {
            System.out.println("Edge: " + u + " " + v);
        }
    }
}
