package Week10;

import java.util.*;

public class javaSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        for (int i = 0; i < n; i++) b.add(sc.next());
        Collections.sort(b, new t2());
        System.out.println(b);
    }

    static class t implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            int s1 = 0, s2 = 0, t1 = x, t2 = y;
            while (x > 0) {
                s1 += x % 10;
                x /= 10;
            }
            while (y > 0) {
                s2 += y % 10;
                y /= 10;
            }
            if (s1 < s2) return -1;
            else if (s1 > s2) return 1;
            else {
                if (t1 < t2) return -1;
                else if (t1 > t2) return 1;
                else return 0;
            }
        }
    }

    public static class t2 implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            if (x.length() < y.length()) return -1;
            else if (x.length() > y.length()) return 1;
            else {
                if (x.compareTo(y) < 0) return -1;
                else if (x.compareTo(y) > 0) return 1;
                else return 0;
            }
        }
    }
}
