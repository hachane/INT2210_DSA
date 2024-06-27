package Week13;

import java.util.*;

public class normalFindDirectedPath {
    static int MAX = 10001;
    static int[] parent = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static List<List<Integer>> adj = new ArrayList<>();

    static void dfs(int u) {
        visited[u] = true;
        for (int v : adj.get(u - 1)) {
            if (!visited[v]) {
                parent[v] = u;
                // visited[v] = true; => no need cuz inside dfs function will do that
                dfs(v);
            }
        }
    }

    static void bfs(int u) {
        visited[u] = true;
        Queue<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < adj.get(u - 1).size(); i++) {
            int v = adj.get(u - 1).get(i);
            visited[v] = true;
            parent[v] = u;
            tmp.add(v);
        }

        while (!tmp.isEmpty()) {
            int cur = tmp.poll();
            for (int v : adj.get(cur - 1)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = cur;
                    tmp.add(v);
                }
            }
        }
    }

    // tim duong di tu dinh s -> e theo dfs
    static boolean checkPath(int startVertex, int endVertex) {
        for (int i = 0; i < MAX; i++) visited[i] = false;
        for (int i = 0; i < MAX; i++) parent[i] = -1;
        bfs(startVertex);
        if (!visited[endVertex]) return false;
        else {
            while (endVertex != startVertex) {
                System.out.println(endVertex);
                endVertex = parent[endVertex];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u - 1).add(v);
            //adj.get(v - 1).add(u);
        }
        int start = sc.nextInt(), end = sc.nextInt();
        if (checkPath(start, end)) {
            System.out.println("co duong");
        } else System.out.println("khong duong");
        /* 10 10
        1 2
        2 3
        2 4
        3 6
        3 7
        6 7
        7 5
        5 8
        5 10
        8 9*/
    }
}
