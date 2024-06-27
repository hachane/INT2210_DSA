package Week9;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class runningMedian {
    private static final PriorityQueue<Integer> smallerNum
            = new PriorityQueue<>(Collections.reverseOrder());
    private static final PriorityQueue<Integer> biggerNum = new PriorityQueue<>();

    public static void add(int n) {
        if (smallerNum.isEmpty()) smallerNum.add(n);
        else if (smallerNum.size() == biggerNum.size()) {
            if (biggerNum.peek() >= n) smallerNum.add(n);
            else {
                biggerNum.add(n);
                smallerNum.add(biggerNum.poll());
            }
        } else if (smallerNum.size() > biggerNum.size()) {
            if (n >= smallerNum.peek()) biggerNum.add(n);
            else {
                smallerNum.add(n);
                biggerNum.add(smallerNum.poll());
            }
        }
    }

    public static double getMed() {
        if (smallerNum.size() == biggerNum.size()) {
            return (smallerNum.peek() * 1.0 + biggerNum.peek()) / 2;
        } else {
            return smallerNum.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            add(sc.nextInt());
            System.out.println(getMed());
        }
    }
}
