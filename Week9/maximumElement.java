package Week9;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class maximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> t = new Stack<>();
        PriorityQueue<Integer> t1 = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int q = sc.nextInt();
            if (q == 1) {
                int t2 = sc.nextInt();
                t.push(t2);
                t1.add(t2);
            } else if (q == 2) {
                if (!t1.isEmpty() && !t.isEmpty()) {
                    t1.remove(t.pop());
                }
            } else {
                System.out.println(t1.peek());
            }
        }
    }
}
