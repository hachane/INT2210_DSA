package Week11;

import java.util.Arrays;
import java.util.Scanner;

public class twoSum {
    public static void main(String[] args) {
        int n1 = 9;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int i = 0, j = n - 1, r = 0;
        while (i < j) {
            int t = a[i] + a[j];
            if (t > k) j--;
            else if (t < k) i++;
            else {
                int t1 = i, t2 = j;
                while (i < n && a[i] == a[t1]) i++;
                while (j >= 0 && a[j] == a[t2]) j--;
                r += (i - t1) * (t2 - j);
            }
        }
        System.out.println(r);
    }
}
