package Week13;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class normalDijkstra {
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int sz = edges.size();

        int sz1 = edges.size();
        for (int i = 0; i < sz1; i++) {
            int v1 = edges.get(i).get(0) - 1;
            int v2 = edges.get(i).get(1) - 1;
            int val = edges.get(i).get(2);
            adj.get(v1).add(new Pair(v2, val));
            adj.get(v2).add(new Pair(v1, val));
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(s - 1, 0));
        int count = 0;
        while (count < n && !pq.isEmpty()) {
            Pair pair = pq.poll();
            int des = pair.des;
            int val = pair.val;
            if (res[des] == -1) {
                System.out.println(des + " " + val);
                res[des] = val;
                sz = adj.get(des).size();
                for (int i = 0; i < sz; i++) {
                    int tmpdes = adj.get(des).get(i).des;
                    int tmpval = val + adj.get(des).get(i).val;
                    if (res[tmpdes] == -1) {
                        pq.add(new Pair(tmpdes, tmpval));
                    }
                }
                count++;
            }
        }
        List<Integer> res1 = new ArrayList<>();
        for (int i : res) {
            res1.add(i);
        }
        res1.remove(s - 1);
        return res1;
    }

    static class Pair implements Comparable<Pair> {
        int des;
        int val;

        public Pair(int des, int val) {
            this.des = des;
            this.val = val;
        }

        public int compareTo(Pair p) {
            return Integer.compare(val, p.val);
        }
    }
}