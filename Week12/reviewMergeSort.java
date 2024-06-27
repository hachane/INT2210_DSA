package Week12;

public class reviewMergeSort {
    public static void m(int[] a, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        for (int i = 0; i < r - l + 1; i++) tmp[i] = a[i + l];
        int i = l, j = m + 1;
        int t = l;
        while (i <= m && j <= r) {
            if (tmp[i - l] <= tmp[j - l]) {
                a[t] = tmp[i - l];
                t++;
                i++;
            } else {
                a[t] = tmp[j - l];
                t++;
                j++;
            }
        }
        while (i <= m) {
            a[t] = tmp[i - l];
            t++;
            i++;
        }
        while (j <= m) {
            a[t] = tmp[j - l];
            t++;
            j++;
        }
    }

    public static void s(int[] a, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        s(a, l, m);
        s(a, m + 1, r);
        m(a, l, m, r);
    }

    public static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

    public static void main(String[] args) {
        int[] a = {1, 10, 4, 5, 7, 2};
        s(a, 0, 5);
        in(a);
    }
}
