package Week10;

import java.util.Arrays;
import java.util.Scanner;

public class twoArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int j = 0; j < m; j++) b[j] = sc.nextInt();
        Arrays.sort(b);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int t = a[i], c1 = 0;
            while (i < n && a[i] == t) {
                i++;
                c1++;
            }
            i--;
            int l = 0, r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (b[mid] > -t) r = mid - 1;
                else if (b[mid] < -t) l = mid + 1;
                else {
                    int tmp = mid;
                    while (tmp < m && b[tmp] == b[mid]) tmp++;
                    cnt += (tmp - mid) * c1;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}
