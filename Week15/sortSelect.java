package Week15;

import java.util.Scanner;

public class sortSelect {
    static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int max = a[n - i - 1];
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > max) {
                    int tmp = a[j];
                    a[j] = max;
                    max = tmp;
                }
            }
            a[n - i - 1] = max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a);
        for (int tmp : a) System.out.print(tmp + " ");
        System.out.println("hjhj");
//        9
//        1 8 2 3 10 2 4 8 7
    }
}
