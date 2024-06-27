package Week15;

import java.util.List;
import java.util.Scanner;

public class sortInsert {
    static long cnt(long n) {
        long ans = 1;
        if (n == 0) return 1;
        if (n % 2 == 1) {
            long y = cnt((n - 1) / 2);
            return 2 * y * y;
        } else {
            long y = cnt(n / 2);
            return y * y;
        }
    }

    static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i - 1;
            while (j >= 0 && tmp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List t;


        long n = sc.nextLong();
        System.out.println(cnt(n));
//        9
//        1 8 2 3 10 2 4 8 7
    }
}
