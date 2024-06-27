package Week15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class reviewGridDFS {
    static char grid[][];
    static boolean visited[][];

    static boolean check(int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid.length) return true;
        return false;
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int ans = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 && j == 0) || (i == -1 && j == -1) || (i == -1 && j == 1) ||
                        (i == 1 && j == -1) || (i == 1 && j == 1)) continue;
                if (!check(x + i, y + j) || grid[x + i][y + j] != '0') continue;
                if (!visited[x + i][y + j]) {
                    ans += dfs(x + i, y + j);
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
            int ans = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && grid[i][j] == '0') {
                        ans++;
                        int tmp = dfs(i, j);
                        res.add(tmp);
                    }
                }
            }
            Collections.sort(res);
            System.out.print(ans);
            for (int tmp : res) System.out.print(tmp + " ");
        }
    }
}
