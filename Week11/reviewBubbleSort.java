package Week11;

public class reviewBubbleSort {
    public static void sort(int[] a) {
        int n = a.length;
        int c = 0;
        boolean sorted = false;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    c++;
                    sorted = true;
                }
            }
            if (!sorted) break;
        }
        System.out.println("so lan:" + c);
    }

    public static void print(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 8, 4, 3, 10};
        sort(a);
        print(a);
    }
}
