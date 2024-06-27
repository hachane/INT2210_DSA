package Week10;

import java.util.Scanner;

public class countingSort {
    public static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) System.out.println(a[i] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] cnt = new int[100];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            a[i] = t;
            cnt[t]++;
        }
        for (int i = 1; i < 100; i++) cnt[i] += cnt[i - 1];
        for (int i = 0; i < n; i++) {
            r[cnt[a[i]] - 1] = a[i];
            cnt[a[i]]--;
        }
        in(r);
    }
}
