package Week4;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),k= sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int res =0;
        Arrays.sort(a);
        int i =0,j=1;
        while(i<n&&j<n){
            if(a[j]-a[i]>k) i++;
            else if (a[j]-a[i]<k) {j++;

            } else if (a[j]-a[i]==k) {
                int tmp1 = i;
                int tmp2=j;
                while(i<n&&a[i]==a[tmp1]) i++;
                while(j<n&&a[j]==a[tmp2])j++;
                res+=(tmp1-i)*(tmp2-j);
            }
        }
        System.out.println(res);
    }
}
