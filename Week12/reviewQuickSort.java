package Week12;

public class reviewQuickSort {
    public static int p(int[] a, int l, int r) {
        int pv = a[r];
        int t = l;
        for (int i = l; i <= r - 1; i++) {
            if (a[i] >= pv) continue;
            else {
                int tmp = a[i];
                a[i] = a[t];
                a[t] = tmp;
                t++;
            }
        }
        a[r] = a[t];
        a[t] = pv;
        for (int x : a) System.out.print(x + " ");
        System.out.print("\n");
        return t;
    }

    public static void q(int[] a, int l, int r) {
        if (l >= r || l < 0 || r < 0) return;
        int i = p(a, l, r);
        q(a, l, i - 1);
        q(a, i + 1, r);
    }

    public static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        q(a, 0, 8);
        in(a);
    }
}
