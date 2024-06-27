package Week11;

public class reviewCountingSort {
    public static void c(int[] a) {
        int n = a.length;
        int c[] = new int[100];
        int r[] = new int[n];
        for (int i = 0; i < n; i++) c[a[i]]++;
        for (int i = 1; i < 100; i++) c[i] += c[i - 1];
        for (int i = 0; i < n; i++) {
            r[c[a[i]] - 1] = a[i];
            c[a[i]] -= 1;
        }
        for (int i = 0; i < n; i++) a[i] = r[i];
    }

    public static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 5, 4, 6, 7};
        c(a);
        in(a);
    }
}
