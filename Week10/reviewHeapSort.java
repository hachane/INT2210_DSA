package Week10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class reviewHeapSort {
    static void swim(List<Integer> a, int i) {
        while (i > 1 && a.get(i - 1) < a.get(i / 2 - 1)) {
            Collections.swap(a, i - 1, i / 2 - 1);
            i /= 2;
        }
    }

    static void sink(List<Integer> a, int i) {
        int n = a.size();
        while (2 * i <= n) {
            int j = 2 * i;
            if (j + 1 <= n && a.get(j + 1 - 1) < a.get(j - 1)) j++;
            if (a.get(j - 1) >= a.get(i - 1)) break;
            Collections.swap(a, i - 1, j - 1);
            i = j;
        }
    }

    static void ins(List<Integer> a, int n) {
        a.add(n);
        swim(a, a.size());
    }

    static int del(List<Integer> a) {
        int r = a.get(0);
        Collections.swap(a, 0, a.size() - 1);
        a.remove(a.size() - 1);
        //luon luon truyen vao ham qs la chi so bat dau tu 1
        //luon luon truyen vao mang trong qs la chi so bat dau tu 0; (i-1);
        sink(a, 1);
        return r;
    }

    static void qs(List<Integer> a) {
        List<Integer> tmp = new ArrayList<>();
        int n = a.size();
        for (int i = 0; i < n; i++) ins(tmp, a.get(i));
        for (int i = 0; i < n; i++) a.set(i, del(tmp));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        qs(a);
        System.out.println(a);
    }
}
