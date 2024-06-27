package Week13;

import java.util.*;

public class normalBFS {
    static int MAX = 10001;
    static boolean[] visited = new boolean[MAX];
    static List<Integer> res = new ArrayList<>();
    static List<List<Integer>> adj = new ArrayList<>();

    // duyet het tat ca cac dinh
    static void bfs(int u) {
        visited[u] = true;
        res.add(u);
        Queue<Integer> tmp = new LinkedList<>();
        for (int v : adj.get(u - 1)) {
            visited[v] = true;
            res.add(v);
            tmp.add(v);
        }
        while (!tmp.isEmpty()) {
            int cur = tmp.poll();
            for (int v : adj.get(cur - 1)) {
                if (!visited[v]) {
                    visited[v] = true;
                    tmp.add(v);
                    res.add(v);
                }
            }
        }
    }

    // dem so dinh lien thong voi dinh hien tai
    static int bfsCnt(int u) {
        int ans = 1;
        visited[u] = true;
        res.add(u);
        Queue<Integer> tmp = new LinkedList<>();
        for (int v : adj.get(u - 1)) {
            visited[v] = true;
            res.add(v);
            tmp.add(v);
            ans++;
        }
        while (!tmp.isEmpty()) {
            int cur = tmp.poll();
            for (int v : adj.get(cur - 1)) {
                if (!visited[v]) {
                    ans++;
                    visited[v] = true;
                    tmp.add(v);
                    res.add(v);
                }
            }
        }
        return ans;
    }

    // dem so thanh phan lien thong trong 1 do thi
    static int componentCnt() {
        int res = 0;
        for (int i = 1; i <= adj.size(); i++) {
            if (!visited[i]) {
                res++;
                bfs(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u - 1).add(v);
            adj.get(v - 1).add(u);
        }
        // if consider alphabetical order
        for (int i = 0; i < n; i++) {
            Collections.sort(adj.get(i));
        }
        // tim thanh phan lien thong lon nhat => bat buoc phai duyet het tat ca cac dinh
        // dem so thanh phan lien thong
        int start = sc.nextInt();
        bfs(start);
        System.out.println(res);
    }
}
