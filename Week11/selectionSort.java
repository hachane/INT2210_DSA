package Week11;

public class selectionSort {
    public static void s(int[] a) {
        int n = a.length;
        int r[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int m_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[m_idx]) m_idx = j;
            }
            int tmp = a[m_idx];
            a[m_idx] = a[i];
            a[i] = tmp;
        }
    }

    public static void in(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 5, 4, 10, 11};
        s(a);
        in(a);
    }
}
