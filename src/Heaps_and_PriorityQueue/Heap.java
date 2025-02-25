package Heaps_and_PriorityQueue;

import java.util.*;

public class Heap {
    /* A heap is an amazing tool whenever you need to
    repeatedly find the maximum or minimum element. */

//    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.remove();
            int secondStone = maxHeap.remove();
            if (firstStone != secondStone) maxHeap.add(firstStone - secondStone);
        }
        return (maxHeap.size() == 0) ? 0: maxHeap.peek();
    }

    //Solution215. kth largest element in an array
    public int findKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.remove();
        }
        return minHeap.peek();
    }

//    public int findKthLargestElement(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

    //Solution347. Find top K frequent elements
    public static int[] topKFrequentElements(int[] nums, int k) {
        int[] topK = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        //* If we want the maximums, we use a min heap so that pops would remove the smallest element.
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        for (int num : counts.keySet()) { //*
            heap.add(num);
            if (heap.size() > k)
                heap.remove(); //once the heap's size exceeds k, remove(), this will remove element with the lowest freq
        }

        for (int i = 0; i < k; i++) {
            topK[i] = heap.remove();
        }
        return topK;
    }

    //Solution658. Find top k closest elements
    public static List<Integer> kClosestElements(int[] arr, int x, int k) {
        TreeMap<Integer, Integer> diffs = new TreeMap<>();
        for (int num: arr) {
            diffs.put(num, Math.abs(num - x));
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) return b - a;
            return Math.abs(b - x) - Math.abs(a - x);
        }
        );

        for (int num: arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) maxHeap.remove();
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(maxHeap.remove());
        }
        Collections.sort(topK);
        return topK;
    }

    //Solution973. k closest points to origin
    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Integer> distances = new HashMap<>();
        for (int[] point: points) {
            int x = point[0], y = point[1];
            distances.put(point, x*x+y*y);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> distances.get(b) - distances.get(a));
        for (int[] point: distances.keySet()) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.remove();
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.remove();
        }
        return result;
    }





    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
        int[] nums = {4,5,5,6,1,1,1,2,3,3};
        System.out.println(Arrays.toString(topKFrequentElements(nums, 3)));
    }
}
