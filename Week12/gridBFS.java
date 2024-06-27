package Week12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class gridBFS {
    public static int[][] grid;
    public static boolean[][] visited;

    public static int count_connected(int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> wait = new LinkedList<>();
        visited[i][j] = true;
        int res = 1;
        wait.add(i * n + j);
        while (!wait.isEmpty()) {
            int y = wait.peek() % n;
            int x = (wait.poll() - y) / n;
            if (x >= 1 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
                wait.add((x - 1) * n + y);
                visited[x - 1][y] = true;
                res++;
            }
            if (x <= m - 2 && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                wait.add((x + 1) * n + y);
                visited[x + 1][y] = true;
                res++;
            }
            if (y >= 1 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
                wait.add(x * n + y - 1);
                visited[x][y - 1] = true;
                res++;
            }
            if (y <= n - 2 && !visited[x][y + 1] && grid[x][y + 1] == 1) {
                wait.add(x * n + y + 1);
                visited[x][y + 1] = true;
                res++;
            }
            if (x >= 1 && y >= 1 && !visited[x - 1][y - 1] && grid[x - 1][y - 1] == 1) {
                wait.add((x - 1) * n + (y - 1));
                visited[x - 1][y - 1] = true;
                res++;
            }
            if (x >= 1 && y <= n - 2 && !visited[x - 1][y + 1] && grid[x - 1][y + 1] == 1) {
                wait.add((x - 1) * n + y + 1);
                visited[x - 1][y + 1] = true;
                res++;
            }
            if (x <= m - 2 && y >= 1 && !visited[x + 1][y - 1] && grid[x + 1][y - 1] == 1) {
                wait.add((x + 1) * n + y - 1);
                visited[x + 1][y - 1] = true;
                res++;
            }
            if (x <= m - 2 && y <= n - 2 && !visited[x + 1][y + 1] && grid[x + 1][y + 1] == 1) {
                wait.add((x + 1) * n + y + 1);
                visited[x + 1][y + 1] = true;
                res++;
            }
        }
        return res;
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);
    }
}
