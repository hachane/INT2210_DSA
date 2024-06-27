package Week10;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class reviewRunningMedian {
    public static PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> b = new PriorityQueue<>();

    static void add(int n) {
        if (s.isEmpty()) s.add(n);
        else if (s.size() == b.size()) {
            if (b.peek() >= n) s.add(n);
            else {
                b.add(n);
                s.add(b.poll());
            }
        } else if (s.size() > b.size()) {
            if (s.peek() <= n) b.add(n);
            else {
                s.add(n);
                b.add(s.poll());
            }
        }
    }

    static double m() {
        if (s.size() == b.size()) return (s.peek() * 1.0 + b.peek()) / 2;
        return s.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            add(sc.nextInt());
            System.out.println(m());
        }
    }
}
