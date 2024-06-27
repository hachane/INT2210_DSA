package Week10;

import java.util.Scanner;
import java.util.Stack;

public class simpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> p = new Stack<>();
        String cur = "";
        p.push(cur);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                cur += sc.next();
                p.push(cur);
            } else if (t == 2) {
                cur = cur.substring(0, cur.length() - sc.nextInt());
                p.push(cur);
            } else if (t == 3) {
                System.out.println(cur.charAt(sc.nextInt() - 1));
            } else if (t == 4) {
                p.pop();
                cur = p.peek();
            }
        }
    }
}
