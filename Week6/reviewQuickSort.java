package Week6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class reviewQuickSort {
    public static int LomutoPartition(List<Integer> a, int l, int r) {
        int pivot = r;
        if (l == r) return l;
        int track = l;
        for (int j = l; j <= r - 1; j++) {
            if (a.get(j) >= a.get(pivot)) {
                continue;
            } else {
                Collections.swap(a,j, track);
                track++;
            }
        }
        Collections.swap(a,track,pivot);
        return track;
    }

    public static int HoarePartition(List<Integer> a, int l, int r) {
        if (l == r) return l;
        int pivot = l;
        int i = l, j = r + 1;
        while(true) {
            while(a.get(++i) < a.get(pivot)) {
                if(i == r) break;
            }
            while(a.get(--j) > a.get(pivot)) {
                if(j == l) break;
            }

            System.out.println("i la " + i + "; j la " + j);
            if(i>=j) break;

            Collections.swap(a,i,j);
            System.out.println(a);
        }
        Collections.swap(a, pivot, j);
        return j;
    }

    public static void quickSort1(List<Integer> a, int begin, int end) {
        if (begin >= end || begin < 0)  return;
        int pivot = LomutoPartition(a, begin, end);
        quickSort1(a, begin, pivot - 1);
        quickSort1(a, pivot + 1, end);
    }
    /*public static int f(List<Integer> a, int r){
        List<Integer> s = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int n=a.size();
        int p=a.get(0);
        for(int i=0;i<n;i++){
            if(a.get(i)>p) b.add(a.get(i));
            else if(a.get(i)<p) s.add(a.get(i));
            else e.add(a.get(i));
        }
        if(s.size()+e.size()>=r&&s.size()<r) return p;
        return ()
    }*/

    public static void quickSort2(List<Integer> a, int begin, int end) {
        if (begin >= end || begin < 0)  return;
        int pivot = HoarePartition(a, begin, end);
        quickSort2(a, begin, pivot - 1);
        quickSort2(a, pivot + 1, end);
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(4,6,5,3);
        HoarePartition(a,0,3);
        System.out.println(a);
    }

}
