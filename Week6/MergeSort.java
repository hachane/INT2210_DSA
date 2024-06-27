package Week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void merge (List<Integer> a, int l, int m, int r) {
        int m1 = m;
        int m2 = m + 1;
        List<Integer> temp = new ArrayList<>();
        for (int i = l; i <= r; i++)
            temp.add(a.get(i));


        int i = l, j = m2;
        int track = l;
        while (i <= m1 && j <= r) {
            if (temp.get(i - l) <= temp.get(j - l)) {
                a.set(track, temp.get(i - l));
                i++;
            } else {
                a.set(track, temp.get(j - l));
                j++;
            }
            track++;
        }
        while(i <= m1) {
            a.set(track, temp.get(i - l));
            track++;
            i++;
        }
        while(j <= r) {
            a.set(track, temp.get(j - l));
            track++;
            j++;
        }
    }
    public static void mergeSort(List<Integer> a, int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // reviewQuickSort first and second halves
            mergeSort(a,l,m);
            mergeSort(a, m + 1, r);

            // Merge the sorted halves
            merge(a, l, m, r);
        }

    }
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(-20,-3916,-35,-362,74,
                -761,30,624,-64,266
        );
        List<Integer> b = Arrays.asList(-9,-10,2,1,6,5,-9,17,13,-7);
        mergeSort(a, 0,9);
        System.out.println(a);
    }
}
