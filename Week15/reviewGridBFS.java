package Week15;

import java.util.*;

public class reviewGridBFS {
    static char grid[][];
    static boolean visited[][];

    static boolean check(int x, int y) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) return true;
        System.out.println(x + " " + y);
        return false;
    }

    static int bfs(int sx, int sy) {
        Queue<p> wait = new LinkedList<>();
        wait.add(new p(sx, sy));
        int ans = 0;
        while (!wait.isEmpty()) {
            p cur = wait.poll();
            int x = cur.x, y = cur.y;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            ans++;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == -1 && j == -1)
                            || (i == 1 && j == -1) || (i == -1 && j == 1)) continue;
                    if (!check(x + i, y + j)) continue;
                    if (grid[x + i][x + j] != '0') continue;
                    wait.add(new p(x + i, y + j));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new char[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                String tmp = sc.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = tmp.charAt(j);
                    visited[i][j] = false;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && grid[i][j] == '0') {
                        int tmp = bfs(i, j);
                        res.add(tmp);
                    }
                }
            }
            for (int x : res) System.out.print(x + " ");
        }
    }

    static class p {
        int x, y;

        p(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
