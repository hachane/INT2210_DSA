package Week15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sortHeap {
    // max heap
    static void swim(List<Integer> a, int idxToSwim) {
        while (idxToSwim > 1 && a.get(idxToSwim / 2 - 1) < a.get(idxToSwim - 1)) {
            Collections.swap(a, idxToSwim / 2 - 1, idxToSwim - 1);
            idxToSwim /= 2;
        }
    }

    static void add(List<Integer> a, int n) {
        a.add(n);
        swim(a, a.size());
    }

    static void sink(List<Integer> a, int idxToSink) {
        while (2 * idxToSink <= a.size()) {
            int child = idxToSink * 2;
            if (child + 1 <= a.size() && a.get(child + 1 - 1) > a.get(child - 1))
                child++;
            // luon luon nho tru 1
            Collections.swap(a, child - 1, idxToSink - 1);
            idxToSink = child;
        }
    }

    static int delMax(List<Integer> a) {
        int r = a.get(0);
        Collections.swap(a, 0, a.size() - 1);
        a.remove(a.size() - 1);
        sink(a, 1);
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) add(a, sc.nextInt());
        for (Integer x : a) System.out.print(x + " ");
        System.out.println("\n" + delMax(a) + "\n");
        for (Integer x : a) System.out.print(x + " ");
    }
}
