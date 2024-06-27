package Week12;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) marked[i] = false;
        List<List<Edge>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u - 1).add(new Edge(u, v, w));
            adjList.get(v - 1).add(new Edge(u, v, w));
        }
        //also start vertex
        int curVertex = sc.nextInt();
        marked[curVertex - 1] = true;
        int s = 0;
        PriorityQueue<Edge> curEdges = new PriorityQueue<>();
        List<Edge> res = new ArrayList<>();
        for (Edge e : adjList.get(curVertex - 1)) {
            curEdges.add(e);
        }
        marked[curVertex - 1] = true;
        while (!curEdges.isEmpty() && res.size() < n - 1) {
            Edge tmp = curEdges.poll();
            if (marked[tmp.u - 1] && marked[tmp.v - 1]) continue;
            s += tmp.w;
            res.add(tmp);
            if (marked[tmp.u - 1] == false) {
                marked[tmp.u - 1] = true;
                for (Edge e : adjList.get(tmp.u - 1)) {
                    if (!curEdges.contains(e)) curEdges.add(e);
                }
            }
            if (marked[tmp.v - 1] == false) {
                marked[tmp.v - 1] = true;
                for (Edge e : adjList.get(tmp.v - 1)) {
                    if (!curEdges.contains(e)) curEdges.add(e);
                }
            }
        }
        //for(Edge e: res) e.in();
        System.out.println(s);
    }

    public static class Edge implements Comparable<Edge> {
        public int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            if (o.w > this.w) return -1;
            else if (o.w < this.w) return 1;
            return 0;
        }

        public void in() {
            System.out.println("vertex: " + this.u + " " + this.v);
        }
    }
}
