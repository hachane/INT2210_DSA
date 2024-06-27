package Week10;

import java.util.*;

public class mergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> te = new ArrayList<>();
        List<Pair> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            te.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(te, new t());
        for (Pair p : te) p.in();
        Pair cur = te.get(0);
        for (int i = 1; i < n; i++) {
            Pair nxt = te.get(i);
            if (cur.e >= nxt.b) cur.e = Math.max(nxt.e, cur.e);
            else {
                r.add(cur);
                cur = nxt;
            }
        }
        r.add(cur);
        for (Pair y : r) y.in();
    }

    static class Pair {
        public int b, e;

        public Pair(int b, int e) {
            this.b = b;
            this.e = e;
        }

        public void in() {
            System.out.println(this.b + " " + this.e);
        }

    }

    static class t implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            if (a.b < b.b) return -1;
            else if (a.b > b.b) return 1;
            else {
                if (a.e < b.e) return -1;
                else if (a.e > b.e) return 1;
                else return 0;
            }
        }
    }
}
