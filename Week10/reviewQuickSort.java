package Week10;

public class reviewQuickSort {
    static int p(int[] a, int l, int r) {
        int pv = a[r];
        int t = l;
        for (int i = l; i <= r; i++) {
            if (a[i] >= pv) continue;
            else {
                int tp = a[t];
                a[t] = a[i];
                a[i] = tp;
                t++;
            }
        }
        // now t is 1 unit ahead the num smaller than pv
        int tp = a[t];
        a[t] = pv;
        a[r] = tp;
        return t;
    }

    static void s(int[] a, int l, int r) {
        if (l >= r) return;
        int p = p(a, l, r);
        s(a, l, p - 1);
        s(a, p + 1, r);
    }

    static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

    public static void main(String[] args) {
        int[] a = {10, 7, 11, 2, 3, 30};
        s(a, 0, 5);
        in(a);
    }
}
