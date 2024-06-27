package Week15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class reviewNormalDFS {

    static List<List<Integer>> e = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int s) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int x : e.get(s - 1)) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }

    static int cnt(int s) {
        visited[s] = true;
        int ans = 1;
        for (int x : e.get(s - 1)) {
            if (!visited[x]) {
                ans += cnt(x);
            }
        }
        return ans;
    }

    static int cntComponent(int s) {
        visited[s] = true;
        dfs(s);
        int r = 1;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i);
                r++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            e.clear();
            int n = sc.nextInt(), m = sc.nextInt();
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                e.add(new ArrayList<>());
                visited[i] = false;
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                e.get(u - 1).add(v);
                e.get(v - 1).add(u);
            }
            int s = sc.nextInt();
            System.out.println(cnt(s));
        }
//        1
//        6 7
//        1 2
//        1 3
//        1 4
//        1 5
//        2 3
//        3 4
//        4 5
//        2
//        8 7
//        1 2
//        1 3
//        2 4
//        2 5
//        4 7
//        4 6
//        3 8
//        1
    }
}
