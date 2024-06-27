package Week10;

import java.util.Arrays;
import java.util.Scanner;

public class threeSumReview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int tmp = a[i] + a[l] + a[r];
                if (tmp < 0) l++;
                else if (tmp > 0) r--;
                else {
                    res++;
                    int s1 = a[l];
                    int s2 = a[r];
                    while (l < n && a[l] == s1) l++;
                    while (r >= 0 && a[r] == s2) r--;
                }
            }
        }
        System.out.println(res);
    }
}
