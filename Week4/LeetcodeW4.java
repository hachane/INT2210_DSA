package Week4;

import java.util.Stack;

public class LeetcodeW4 {
    /**
     * Bai 7. min length string after removing substring.
     */
    public static int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i) == 'B') {
                    if (!st.isEmpty() && st.peek() == 'A') {
                        st.pop();
                    } else {
                        st.push(s.charAt(i));
                    }
                } else if (s.charAt(i) == 'D') {
                    if (!st.isEmpty() && st.peek() == 'C') {
                        st.pop();
                    } else {
                        st.push(s.charAt(i));
                    }
                } else {
                    st.push(s.charAt(i));
                }
            }
        }
        String tmp = "";
        while (!st.isEmpty()) {
            tmp += st.pop();
        }
        System.out.println(tmp);
        return st.size();
    }

    public static void main(String[] args) {
        System.out.println(minLength("ACBBD"));
    }

    /**
     * Bai 1.
     */
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> store = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!store.isEmpty()) {
                if (s.charAt(i) == store.peek()) {
                    store.pop();
                } else {
                    store.push(s.charAt(i));
                }
            } else {
                store.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!store.isEmpty()) {
            res.append(store.pop());
        }
        return res.reverse().toString();

    }

    /**
     * Bai 2. Baseball game
     */
    public int calPoints(String[] operations) {
        Stack<Integer> store = new Stack<>();
        int n = operations.length;
        for (int i = 0; i < n; i++) {
            if (operations[i].equals("C")) {
                store.remove(store.size() - 1);
            } else if (operations[i].equals("D")) {
                store.push(store.peek() * 2);
            } else if (operations[i].equals("+")) {
                int temp = store.pop();
                int res = temp + store.peek();
                store.push(temp);
                store.push(res);
            } else {
                store.push(Integer.parseInt(operations[i]));
            }
        }
        int res = 0;
        while (!store.isEmpty()) {
            res += store.pop();
        }
        return res;
    }

    /**
     * Bai 3. => need to read again
     */
    public String removeOuterParentheses(String s) {
        Stack<Character> t = new Stack<>();
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (t.size() > 0) {
                    r.append(s.charAt(i));
                }
                t.push(s.charAt(i));
            } else {
                t.pop();
                if (t.size() > 0) {
                    r.append(s.charAt(i));
                }
            }
        }
        return r.toString();
    }

    /**
     * Bai 5. Make the string great
     */
    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> tmp = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (tmp.isEmpty()) {
                tmp.push(s.charAt(i));
            } else {
                if (tmp.peek() == s.charAt(i) - 32 || tmp.peek() == s.charAt(i) + 32) {
                    tmp.pop();
                } else {
                    tmp.push(s.charAt(i));
                }
            }
        }
        String res = "";
        while (!tmp.isEmpty()) {
            res += tmp.pop().toString();
        }
        int n1 = res.length();
        String res1 = "";
        for (int i = n1 - 1; i >= 0; i--) {
            res1 += res.charAt(i);
        }
        return res1;
    }

    /**
     * Bai 6. max nest depth of the parentheses
     */
    public int maxDepth(String s) {
        int m = 0, tr = 0;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
                tr++;
                m = Math.max(tr, m);
            } else if (s.charAt(i) == ')' && !st.isEmpty()) {
                st.pop();
                tr--;
            }
        }
        return m;
    }

    /**
     * Bai 9. crawler log folder.
     */
    public int minOperations(String[] l) {
        int y = l.length;
        Stack<String> n = new Stack<>();
        for (int i = 0; i < y; i++) {
            if (l[i].equals("../")) {
                if (!n.isEmpty()) {
                    n.pop();
                }
            } else if (l[i].equals("./")) {
                continue;
            } else {
                n.push(l[i]);
            }
        }
        return n.size();
    }

    /**
     * Bai 10. backspace string compare.
     */
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '#') {
                s1.push(s.charAt(i));
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (t.charAt(i) != '#') {
                t1.push(t.charAt(i));
            } else {
                if (!t1.isEmpty()) {
                    t1.pop();
                }
            }
        }
        while (!s1.isEmpty() && !t1.isEmpty()) {
            if (s1.pop() != t1.pop()) {
                return false;
            }
        }
        if (s1.isEmpty() && !t1.isEmpty()) {
            return false;
        }
        return s1.isEmpty() || !t1.isEmpty();
    }

    /**
     * Bai 3. Number of students unable to eat lunch.
     * unhappy path: all remaining students want X type of sandwich but X has sold out,
     * the head of sandwiches is the one that none of the students wants
     * students.count(sandwiches[0]) == 0
     * We stop at sandwiches[k] if no one wants it,
     * then n - k students are unable to eat.
     */
    public int countStudents(int[] st, int[] sa) {
        int[] cnt = {0, 0};
        int n = st.length, k;
        for (int a : st) {
            cnt[a]++;
        }
        for (k = 0; k < n && cnt[sa[k]] > 0; k++) {
            cnt[sa[k]]--;
        }
        return n - k;
    }

    /**
     * Bai 4. Time needed to buy tickets.
     * For position k, you have to wait for all buyers before you to finish first
     * since each buy is 1 second, which is why we get min(a[i], a[k]).
     * For the buyers after you, when you have to wait for them,
     * you are already at the end of the line
     * which means you already buy your first ticket, which is why we use min(a[k] - 1, a[i]).
     */
    public int timeRequiredToBuy(int[] t, int k) {
        int n = t.length;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                r += Math.min(t[i], t[k]);
            } else {
                r += Math.min(t[k] - 1, t[i]);
            }
        }
        return r;
    }
}