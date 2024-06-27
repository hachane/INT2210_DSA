package Week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class removePlates {
    public static void main(String[] args) {
        List<Integer> c1 = new ArrayList<>();
        List<Integer> c2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int t = sc.nextInt();
        for (int i = 0; i < n; i++) c1.add(sc.nextInt());
        for (int i = 0; i < m; i++) c2.add(sc.nextInt());
        int c = 0;
        while (t > 0 && (!c1.isEmpty() || !c2.isEmpty())) {
            if (!c1.isEmpty() && !c2.isEmpty() && c1.get(0) <= c2.get(0)) {
                t -= c1.get(0);
                c1.remove(0);
                c++;
            } else if (!c1.isEmpty() && !c2.isEmpty() && c1.get(0) > c2.get(0)) {
                t -= c2.get(0);
                c2.remove(0);
                c++;
            } else if (!c1.isEmpty() && c2.isEmpty()) {
                t -= c1.get(0);
                c1.remove(0);
                c++;
            } else if (c1.isEmpty() && !c2.isEmpty()) {
                t -= c2.get(0);
                c2.remove(0);
                c++;
            }
        }
        System.out.println(c);
    }
}
