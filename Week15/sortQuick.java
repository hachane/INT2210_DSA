package Week15;

import java.util.Scanner;

public class sortQuick {
    static int partition(int[] a, int l, int r) {
        if (l >= r) return l;
        int pivot = a[l];
        int t = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] >= pivot) {
                //System.out.println(a[i] + " " + pivot);
                continue;
            } else if (a[i] < pivot) {
                int tmp = a[t];
                a[t] = a[i];
                a[i] = tmp;
                t++;
                //System.out.print("hien tai: ");
                //for (int tmp1 : a) System.out.print(tmp1 + " ");
            }
        }
        t--;
        a[l] = a[t];
        a[t] = pivot;
        return t;
    }

    static void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        sort(a, l, p - 1);
        // reviewBubbleSort(a,p+1,r) chu khong phai reviewBubbleSort(a,p,r)
        sort(a, p + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a, 0, n - 1);
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");

        //        9
//        1 8 2 3 10 2 4 8 7
    }
}
