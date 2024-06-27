package Week13;

import java.util.PriorityQueue;
import java.util.Scanner;

public class gridDijkstra {
    static int n, m;
    static int sx, sy;
    static int ex, ey;
    static char inp[][];
    static int dist[][];

    static boolean checkValid(int i, int j) {
        if (i >= 0 && i <= m - 1 && j >= 0 && j <= n - 1) return true;
        return false;
    }

    static int dijkstra() {
        PriorityQueue<vertex> wait = new PriorityQueue<>();
        wait.add(new vertex(0, sx, sy));
        dist[sx][sy] = 0;
        while (!wait.isEmpty()) {
            vertex cur = wait.poll();
            if (dist[cur.i][cur.j] != cur.w) continue;
            for (int dx = -1; dx <= 1; dx += 2) {
                for (int dy = -1; dy <= 1; dy += 2) {
                    int tmpx = cur.i + dx;
                    int tmpy = cur.j + dy;
                    if (!checkValid(tmpx, tmpy) || inp[tmpx][tmpy] == '0') continue;
                    int uv = (inp[tmpx][tmpy] == 'f' ? 0 : (inp[tmpx][tmpy] - 48));
                    if (dist[tmpx][tmpy] > cur.w + uv) {
                        dist[tmpx][tmpy] = cur.w + uv;
                        wait.add(new vertex(dist[tmpx][tmpy], tmpx, tmpy));
                    }
                }
            }
        }
        return (dist[sx][sy] == Integer.MAX_VALUE ? -1 : dist[sx][sy]);
    }

    static int dijkstraForOne() {
        PriorityQueue<vertex> wait = new PriorityQueue<>();
        wait.add(new vertex(0, sx, sy));
        dist[sx][sy] = 0;
        while (!wait.isEmpty() && (wait.peek().i != ex || wait.peek().j != ey)) {
            vertex cur = wait.poll();
            if (dist[cur.i][cur.j] != cur.w) continue;
            for (int dx = -1; dx <= 1; dx += 2) {
                for (int dy = -1; dy <= 1; dy += 2) {
                    int tmpx = cur.i + dx;
                    int tmpy = cur.j + dy;
                    if (!checkValid(tmpx, tmpy) || inp[tmpx][tmpy] == '0') continue;
                    int uv = (inp[tmpx][tmpy] == 'f' ? 0 : (inp[tmpx][tmpy] - 48));
                    if (dist[tmpx][tmpy] > cur.w + uv) {
                        dist[tmpx][tmpy] = cur.w + uv;
                        wait.add(new vertex(dist[tmpx][tmpy], tmpx, tmpy));
                    }
                }
            }
        }
        if (!wait.isEmpty()) dist[sx][sy] = wait.peek().w;
        return (dist[sx][sy] == Integer.MAX_VALUE ? -1 : dist[sx][sy]);
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        inp = new char[n][m];
        for (int i = 0; i < m; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                inp[i][j] = tmp.charAt(j);
                if (inp[i][j] == 's') {
                    sx = i;
                    sy = j;
                }
                if (inp[i][j] == 'f') {
                    ex = i;
                    ey = j;
                }
            }
        }

    }

    static class vertex implements Comparable<vertex> {
        int i, j, w;

        public vertex(int w, int i, int j) {
            this.i = i;
            this.j = j;
            this.w = w;
        }

        @Override
        public int compareTo(vertex o) {
            if (w > o.w) return 1;
            else if (w < o.w) return -1;
            return 0;
        }
    }
}
