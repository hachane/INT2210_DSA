package Week13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gridDFS {
    static int[][] grid;
    static boolean[][] visited;

    // dem so node trong 1 thanh phan lien thong
    public static int dfs(int u, int v) {
        visited[u][v] = true;
        int ans = 1;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (u + i >= 0 && u + i < grid.length && v + j >= 0 && v + j < grid[0].length && !visited[u + i][v + j] && grid[u + i][v + j] == 1)
                    ans += dfs(u + i, v + j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        grid = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = dfs(i, j);
                // dem so thanh phan lien thong
                tmp.add(cnt);
                if (max < cnt) max = cnt;
            }
        }
        System.out.println(tmp);
    }
}
