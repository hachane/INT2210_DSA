package Week15;

import java.util.Scanner;

public class sortBubble {
    static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {
            boolean need = false;
            // dua xuong cuoi mang thi moi phan tu phai so sanh voi thang o dang sau no
            for (int j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    need = true;
                }
            }
            if (!need) break;
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
//        9
//        1 8 2 3 10 2 4 8 7
    }
}
