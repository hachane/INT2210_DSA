package Week15;

import java.util.Scanner;

public class sortCount {
    static void sort(int[] a) {
        int max = a[0];
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = a[i];
        for (int tmp : a) {
            if (tmp > max) max = tmp;
        }
        int[] count = new int[max + 1];
        for (int tmp : a) {
            count[tmp]++;
        }
        for (int i = 1; i < max + 1; i++) count[i] += count[i - 1];
        for (int i = 0; i < n; i++) {
            a[count[res[i]] - 1] = res[i];
            count[res[i]]--;
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
