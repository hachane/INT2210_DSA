package Week11;

import java.util.*;

public class reviewMergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> tmp = new ArrayList<>();
        List<Pair> r = new ArrayList<>();
        for (int i = 0; i < n; i++) tmp.add(new Pair(sc.nextInt(), sc.nextInt()));
        Collections.sort(tmp, new t());
        //for(Pair p:Solution) System.out.println(p.b+" "+p.e);
        Pair c = tmp.get(0);
        for (int i = 1; i < n; i++) {
            Pair nx = tmp.get(i);
            if (c.e >= nx.b) c.e = Math.max(nx.e, c.e);
            else {
                r.add(c);
                c = nx;
            }
        }
        r.add(c);
        for (Pair p : r) System.out.println(p.b + " " + p.e);
    }

    static class Pair {
        public int b, e;

        public Pair(int b, int e) {
            this.b = b;
            this.e = e;
        }
    }

    static class t implements Comparator<Pair> {
        @Override
        public int compare(Pair x, Pair y) {
            if (x.b < y.b) return -1;
            else if (x.b > y.b) return 1;
            else {
                if (x.e < y.e) return -1;
                else if (x.e > y.e) return 1;
                else return 0;
            }
        }
    }
}
