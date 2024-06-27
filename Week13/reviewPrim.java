package Week13;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class reviewPrim {
    static boolean[] visited;
    static List<List<edge>> adj = new ArrayList<>();
    static PriorityQueue<edge> curEdges = new PriorityQueue<>();

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = false;
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u - 1).add(new edge(u, v, w));
            adj.get(v - 1).add(new edge(v, u, w));
        }
        int start = sc.nextInt();
        int twoSum = 0;
        List<edge> res = new ArrayList<>();

        visited[start] = true;
        for(edge e: adj.get(start - 1)) curEdges.add(e);

        while (!curEdges.isEmpty() && res.size() < n - 1) {
            edge tmp = curEdges.poll();
            if (visited[tmp.u] && visited[tmp.v]) continue;
            twoSum += tmp.w;
            res.add(tmp);
            if (visited[tmp.u] == false) {
                visited[tmp.u] = true;
                for (edge e: adj.get(tmp.u - 1)) {
                    curEdges.add(e);
                }
            }
            if(visited[tmp.v] == false) {
                visited[tmp.v] = true;
                for (edge e: adj.get(tmp.v - 1)) {
                    curEdges.add(e);
                }
            }
        }*/
        String tmp = "động_vật";
        System.out.println(tmp.replaceAll("_", " "));
        //System.out.println(twoSum);
    }

    public static class edge implements Comparable<edge> {
        public int u, v, w;

        public edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(edge o) {
            if (w > o.w) return 1;
            else if (w < o.w) return -1;
            return 0;
        }
    }
}
