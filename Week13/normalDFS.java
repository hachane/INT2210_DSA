package Week13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class normalDFS {
    static int MAX = 1001;
    static boolean[] visited = new boolean[MAX];
    static List<Integer> res = new ArrayList<>();
    static List<List<Integer>> adj = new ArrayList<>();

    // duyet het tat cac dinh
    static void dfs(int u) {
        res.add(u);
        visited[u] = true;
        for (int v : adj.get(u - 1)) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    // duyet xem dinh hien tai co bao nhieu dinh lien thong voi no; dem so dinh lien thong voi dinh hien tai
    static int dfsCnt(int u) {
        res.add(u);
        int ans = 1;
        visited[u] = true;
        for (int v : adj.get(u - 1)) {
            if (!visited[v]) {
                ans += dfsCnt(v);
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
                dfs(i);
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
        int start = sc.nextInt();
        //dfs(start);
        //System.out.println(res);
        System.out.println(dfsCnt(start));
    }
}
