package Week10;

import java.util.Arrays;
import java.util.Scanner;

public class twoPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int i = 0, j = n - 1;
        int r = 0;
        while (i < j) {
            int t = a[i] + a[j];
            if (t < k) i++;
            else if (t > k) j--;
            else {
                int s1 = i;
                int s2 = j;
                while (i < n && a[i] == a[s1]) i++;
                while (j >= 0 && a[j] == a[s2]) j--;
                System.out.println(a[s1] + " " + a[s2]);
                r += (i - s1) * (s2 - j);
            }
        }
        System.out.println(r);

    }
}
