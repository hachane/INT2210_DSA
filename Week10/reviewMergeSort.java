package Week10;

public class reviewMergeSort {
    static void m(int[] a, int l, int m, int r) {
        if (l >= r) return;
        int[] tmp = new int[r - l + 1];
        if (r + 1 - l >= 0) System.arraycopy(a, l, tmp, l - l, r + 1 - l);
        int i = l, j = m + 1;
        int t = l;
        while (i <= m && j <= r) {
            if (tmp[i - l] >= tmp[j - l]) {
                a[t] = tmp[i - l];
                i++;
                t++;
            } else {
                a[t] = tmp[j - l];
                j++;
                t++;
            }
        }
        while (j <= r) {
            a[t] = tmp[j - l];
            j++;
            t++;
        }
        while (i <= m) {
            a[t] = tmp[i - l];
            i++;
            t++;
        }
    }

    static void s(int[] a, int l, int r) {
        if (l == r) return;
        int m = l + (r - l) / 2;
        s(a, l, m);
        s(a, m + 1, r);
        m(a, l, m, r);
    }

    static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

    public static void main(String[] args) {
        int[] a = {9, 0, 19, 3, 4, 7, 6, 2};
        s(a, 0, 7);
        in(a);
    }
}

