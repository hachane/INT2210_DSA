package Week11;

public class insertionSort {
    public static void insert(int[] a) {
        int n = a.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) tmp[i] = i;
        for (int i = 1; i < n; i++) {
            int t = a[i];
            int j = i - 1;
            int j_idx = i;
            while (j >= 0 && a[j] > a[i]) {
                a[j + 1] = a[j];
                tmp[j + 1] = tmp[j];
                j--;
            }
            a[j + 1] = t;
            tmp[j + 1] = j_idx;
        }
        in(tmp);
    }

    public static void in(int[] a) {
        System.out.println("\n");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 4};
        insert(a);
        in(a);
    }
}
