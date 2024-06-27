package Week10;

import java.util.Scanner;
import java.util.Stack;

public class advancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> t = new Stack<>();
        String s = sc.next();
        int n = s.length();
        boolean f = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                t.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (t.isEmpty() || t.pop() != '(') {
                    System.out.println("INVALID");
                    return;
                }
            } else if (s.charAt(i) == ']') {
                if (t.isEmpty() || t.pop() != ']') {
                    System.out.println("INVALID");
                    return;
                }
                if (t.peek() == ')') {
                    System.out.println("INVALID");
                    return;
                }
            } else if (s.charAt(i) == '}') {
                if (t.isEmpty() || t.pop() != '}') {
                    System.out.println("INVALID");
                    return;
                }
                if (t.peek() == ')' || t.peek() == ']') {
                    System.out.println("INVALID");
                    return;
                }
            }
        }
    }
}
