package tree;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:37 2018/3/8
 * @ ModifiedBy:
 */
public class KLeastNumbersHeap40 {

    public static void main(String[] args) {
        KLeastNumbersHeap40 k = new KLeastNumbersHeap40();
        int[] nums = {4,5,1,6,2,7,3,8,1,5,3};
        TreeSet<Integer> set = new TreeSet<Integer>();
        KLeastNumbersHeap40.getLeastNumber(nums, 5, set);
    }
    public static void getLeastNumber(int[] nums, int k, TreeSet<Integer> set) {
        // using Red-Black Tree TreeSet to solve top k
        for (int i = 0; i < nums.length; i++) {
            if (i < k) set.add(nums[i]);
            else {
                int max = set.last();
                if (nums[i] < max) {
                    set.remove(set.last());
                    set.add(nums[i]);
                }
            }
        }
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        //using An array to simulate Maximum Top Heap
        int[] heap = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) heap[i] = nums[i];
            else {
                int max = maxTopHeap(heap);
                if (nums[i] < max) {
                    heap[0] = nums[i];
                    sink(heap);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(heap[i]);
        }
    }

    private static int maxTopHeap(int[] heap) {
        int n = heap.length;
        for (int i = n-1; i >= 0; i--) {
            swim(heap, i);
        }
        return heap[0];
    }

    private static void swim(int[] heap, int k) {
        while (k > 0 && heap[(k-1)/2] < heap[k]) {
            exch(heap, k, (k-1)/2);
            k = (k-1)/2;
        }
    }

    private static void sink(int[] heap) {
        int j = 0;
        int n = heap.length;
        while (j < n) {
            int next = j*2 + 1;
            if (next >= n) break;
            if (next + 1 < n && heap[next] < heap[next+1]) next++;
            if (heap[j] >= heap[next]) break;
            exch(heap, j, next);
            j= next;
        }
    }
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
