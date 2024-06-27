package Week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HeapSort {
    public static void swim(List<Integer> a, int i) {
        while (i > 0 && a.get(i / 2) < a.get(i)) {
            Collections.swap(a, i / 2, i);
            i = i / 2;
        }
    }

    public static void sink(List<Integer> a, int k) {
        int n = a.size();
        //System.out.println("num 2 si " + a.get(0));
        while (2 * k + 1 < n - 1) {
            int j = k * 2 + 1;
            if (j < n - 2 && a.get(j) < a.get(j + 1)) j++;
            if (a.get(k) > a.get(j)) break;
            Collections.swap(a, k, j);
            k = j;
        }
        //System.out.println(a);
    }

    public static void insert(List<Integer> a, int n) {
        a.add(n);
        swim(a, a.size() - 1);
    }

    public static int delete(List<Integer> a) {
        int max = a.get(0);
        //System.out.println("here " + a.get(0) + " " + a.get(a.size() - 1));
        Collections.swap(a, 0, a.size() - 1);
        sink(a, 0);
        a.remove(a.size() - 1);
        return max;
    }

    public static void heapSort(List<Integer> a) {
        int n = a.size();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            insert(tmp, a.get(i));
        }
        for (int i = 0; i < n; i++) {
            a.set(i, delete(tmp));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        insert(A, 9);
        System.out.println(A);
        heapSort(A);
        System.out.println(A);
    }
}
