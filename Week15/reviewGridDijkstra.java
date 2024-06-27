package Week15;

import java.util.PriorityQueue;
import java.util.Scanner;

public class reviewGridDijkstra {
    static char[][] grid;
    static int[][] dist;

    static boolean check(int x, int y) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid.length) return true;
        return false;
    }

    static int dijOne(int sx, int sy, int ex, int ey) {
        PriorityQueue<ver> wait = new PriorityQueue<>();
        dist[sx][sy] = 0;
        wait.add(new ver(sx, sy, 0));
        while (!wait.isEmpty() && (wait.peek().x != ex || wait.peek().y != ey)) {
            ver cur = wait.poll();
            int x = cur.x, y = cur.y, c = cur.c;
            if (c != dist[x][y]) continue;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == -1 && j == -1) || (i == 1 && j == 1) || (i == -1 && j == 1) || (i == 1 && j == -1) || (i == 0 && j == 0))
                        continue;
                    if (!check(x + i, y + j) || grid[x + i][y + j] == '0') continue;
                    int uv = (grid[x + i][y + j] == 'f' ? 0 : grid[x + i][y + j] - 48);
                    if (dist[x + i][y + j] > c + uv) {
                        dist[x + i][y + j] = c + uv;
                        wait.add(new ver(x + i, y + j, c + uv));
                    }
                }
            }
        }
        return dist[ex][ey];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int m = sc.nextInt(), n = sc.nextInt();
            int sx = 0, sy = 0, ex = 0, ey = 0;
            dist = new int[m][n];
            grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                String tmp = sc.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = tmp.charAt(j);
                    dist[i][j] = Integer.MAX_VALUE;
                    if (grid[i][j] == 's') {
                        sx = i;
                        sy = j;
                    }
                    if (grid[i][j] == 'f') {
                        ex = i;
                        ey = j;
                    }
                }
            }
            System.out.println(dijOne(sx, sy, ex, ey));
        }
    }

    static class ver implements Comparable<ver> {
        int x, y, c;

        ver(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(ver o) {
            if (c > o.c) return 1;
            else if (c < o.c) return -1;
            return 0;
        }
    }
}
