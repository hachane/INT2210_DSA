package Week5;

import java.util.List;
import java.util.Stack;

public class ReviewStack {
    public static String isBalanced(String s) {
        int n = s.length();
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                temp.push(s.charAt(i));
            } else if (temp.isEmpty()) return "NO";
            else if (s.charAt(i) == ')') {
                if (temp.pop() != '(') return "NO";
            } else if (s.charAt(i) == '}') {
                if (temp.pop() != '{') return "NO";
            } else if (s.charAt(i) == ']') {
                if (temp.pop() != '[') return "NO";
            }
        }
        return "YES";
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> t1 = new Stack<>(), t2 = new Stack<>(), t3 = new Stack<>();
        int s1 = 0, s2 = 0, s3 = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            t1.push(h1.get(i));
            s1 += h1.get(i);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            t2.push(h2.get(i));
            s2 += h2.get(i);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            t3.push(h3.get(i));
            s3 += h3.get(i);
        }
        while (!t1.isEmpty() && !t2.isEmpty() && !t3.isEmpty()) {
            if (s1 == s2 && s2 == s3) return s1;
            if (s1 >= s2 && s1 >= s3) s1 -= t1.pop();
            else if (s2 >= s1 && s2 >= s3) s2 -= t2.pop();
            else if (s3 >= s1 && s3 >= s2) s3 -= t3.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "[](){()}";
        System.out.print(isBalanced(s));
    }
}