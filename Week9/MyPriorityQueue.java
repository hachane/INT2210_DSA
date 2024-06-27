package Week9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyPriorityQueue {
    private List<Integer> PQ;
    private int N;
    public MyPriorityQueue() {
        PQ = new ArrayList<>();
        N = 0;
    }


    // Up heap the node k
    private void swim(int k) {
        while (k > 1 && PQ.get(k-1) > PQ.get((int) (k/2) -1)) {
            Collections.swap(PQ, (int) (k/2) -1, k-1);
            k = k/2;
        }
    }


    // Insert a value to the priority queue
    public void insert(int addValue) {
        N++;
        PQ.add(addValue);
        swim(N);
    }

    //Downheap
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            // choose the larger child to swap with parent
            if (j < N && PQ.get(j - 1) < PQ.get(j)) j++;
            // check if heap order restored
            if (PQ.get(k - 1) > PQ.get(j - 1)) break;
            Collections.swap(PQ, k - 1, j - 1);
            k = j;
        }
    }

    // Delete node max
    public int deleteMax() {
        int max = PQ.get(0);
        Collections.swap(PQ, 0, N-1);
        N--;
        sink(1);
        PQ.remove(N);
        return max;
    }

    public int peek() {
        return PQ.get(0);
    }

    public int size() {
        return PQ.size();
    }
}