package Week15;

import java.util.Scanner;

public class sortMerge {
    static void merge(int[] a, int l, int m, int r) {
        if (l >= r) return;
        int p1 = l, p2 = m + 1;
        int[] c = new int[r - l + 1];
        for (int i = l; i <= r; i++) c[i - l] = a[i];
        int track = l;
        while (p1 <= m && p2 <= r) {
            // luon luon nho tru l

            if (c[p1 - l] >= c[p2 - l]) {
                a[track] = c[p1 - l];
                track++;
                p1++;
            } else {
                a[track] = c[p2 - l];
                track++;
                p2++;
            }
        }
        while (p1 <= m) {
            a[track] = c[p1 - l];
            track++;
            p1++;
        }
        while (p2 <= r) {
            a[track] = c[p2 - l];
            track++;
            p2++;
        }
    }

    static void sort(int a[], int l, int r) {
        if (l >= r) return;
        int m = (r - l) / 2 + l;
        sort(a, l, m);
        sort(a, m + 1, r);
        merge(a, l, m, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a, 0, n - 1);
        for (int tmp : a) System.out.print(tmp + " ");
//        9
//        1 8 2 3 10 2 4 8 7
    }
}
