package Week15;

import java.util.*;

public class reviewNormalBFS {
    static boolean[] visited;
    static List<List<Integer>> e = new ArrayList<>();

    static List<Integer> bfs(int s) {
        int n = e.size();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> wait = new LinkedList<>();
        wait.add(s);
        int cnt = 0;
        while (!wait.isEmpty()) {
            int cur = wait.poll();
            visited[cur] = true;
            res.add(cur);
            for (int adj : e.get(cur - 1)) {
                if (!visited[adj]) {
                    wait.add(adj);
                    visited[adj] = true;
                }
            }
        }
        //System.out.println(res.size());
        return res;
    }

    static int cnt(int s) {
        int ans = 1;
        visited[s] = true;
        bfs(s);
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                ans++;
                bfs(i);
            }
        }
        return ans;
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
                //System.out.println("size" + e.size());
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                e.get(u - 1).add(v);
                e.get(v - 1).add(u);
            }
            int s = sc.nextInt();
            //List<Integer> res = bfs(s);
            int x = cnt(s);
//            for (int i = 0; i < n; i++) {
//                System.out.print(res.get(i) + " ");
//            }
            System.out.println(x);
        }
    }
//    1
//            6 7
//            1 2
//            1 3
//            1 4
//            1 5
//            2 3
//            3 4
//            4 5
//            2
}
