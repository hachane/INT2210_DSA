package Week13;

import java.util.LinkedList;
import java.util.Queue;


public class reviewGridBFS {
    static int[][] grid;
    static boolean[][] visited;

    public static int bfs(int u, int v) {
        int row = grid.length, col = grid[0].length;
        visited[u][v] = true;
        int ans = 1;
        Queue<Integer> tmp = new LinkedList<>();
        tmp.add(u * row + v);
        while (!tmp.isEmpty()) {
            int cur = tmp.poll();
            int y = cur % row;
            int x = (cur - y) / row;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (x + i >= 0 && x + i < row && y + j >= 0 && y + j < col
                            && !visited[x + i][y + j] && grid[x + i][y + j] == 1) {
                        visited[x + i][y + j] = true;
                        ans++;
                        tmp.add((x + i) * row + y + j);
                    }
                }
            }
        }
        return ans;
    }
}


