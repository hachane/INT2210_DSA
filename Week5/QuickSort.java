package Week5;

import java.util.*;

public class QuickSort {
    public static void print(List<Integer> a) {
        int n = a.size();
        for (int i = 0; i <= n - 1; i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.print("\n");
    }

    public static int partition(List<Integer> a, int l, int r) {
        int pivot = l;
        if (l == r) return r;
        int i = l + 1, j = r;
        while (true) {
            while (a.get(i) < a.get(pivot)) {
                i++;
                if (i == r) break;
            }
            while (a.get(j) > a.get(pivot)) {
                j--;
                if (j == l + 1) break;
            }
            if (i >= j) break;

            Collections.swap(a, i, j);

        }
        Collections.swap(a, pivot, j);
        return j;
    }

    public static void quicksort(List<Integer> a, int lo, int hi) {
        if (lo >= hi || lo < 0) return;
        int pivot = partition(a, lo, hi);

        // reviewQuickSort the two partitions
        quicksort(a, lo, pivot - 1); // Left side of pivot
        quicksort(a, pivot + 1, hi); // Right side of pivot
    }

    public static int find_med(List<Integer> a, int lo, int hi, int med) {
        int pivot = partition(a, lo, hi);
        if (pivot == med) return a.get(med);
        else if (pivot < med) {
            return find_med(a, pivot + 1, hi, med);
        } else {
            return find_med(a, lo, pivot - 1, med);
        }
    }

    public static int findMedian(List<Integer> a) {
        int n = a.size();
        int med = n / 2;
        int res = find_med(a, 0, n - 1, med);
        return res;
    }

    /**
     * Bai 1: three twoSum.
     */
    public static List<List<Integer>> threeSum(int[] a) {

        Arrays.sort(a);
        int n = a.length;
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int curSum = a[i] + a[l] + a[r];
                if (curSum > 0) r--;
                else if (curSum < 0) l++;
                else {
                    List<Integer> newTrip = new ArrayList<>();
                    newTrip.add(a[i]);
                    newTrip.add(a[r]);
                    newTrip.add(a[l]);
                    res.add(newTrip);
                }
            }
        }
        List<List<Integer>> b = new ArrayList<>(res);
        return b;
    }

    /**
     * Bai 2: Pairs.
     */
    public static int pairs(int k, List<Integer> a) {
        int res = 0;
        int n = a.size();
        Collections.sort(a);
        int l = 0, r = 1;
        while (r < n) {
            int diff = a.get(r) - a.get(l);
            if (diff == k) {
                res++;
                r++;
            } else if (diff > k) {
                l++;
            } else if (diff < k) {
                r++;
            }
        }
        return res;
    }

    /*Bai 5. Smallest diff*/
    public static List<Integer> closestNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int m = a.get(1) - a.get(0);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i + 1) - a.get(i) < m) {
                m = a.get(i + 1) - a.get(i);
                res.clear();
            }
            if (a.get(i + 1) - a.get(i) == m) {
                res.add(a.get(i));
                res.add(a.get(i + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        int k, n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            a.add(tmp);
        }
        System.out.println(pairs(k, a));
    }

    /**
     * Bai 3: Longest harmony sequence.
     */
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 1;
        int res = 0;
        int diff = 0;
        while (r < n) {
            diff = nums[r] - nums[l];
            if (diff == 1) {
                res = Math.max(r - l + 1, res);
            }

            if (diff <= 1) r++;
            else l++;
        }
        return res;
    }

    /**
     * Bai 4: fair candy swap.
     */
    public int[] fairCandySwap(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int suma = 0, sumb = 0;
        for (int i = 0; i < a.length; i++) suma += a[i];
        for (int i = 0; i < b.length; i++) sumb += b[i];
        int dif = suma - sumb;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] - b[j] == dif / 2)
                    return new int[]{a[i], b[j]};
            }
        }
        return null;
    }
}
