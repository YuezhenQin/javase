package Stacks_and_Queues;

import java.util.*;

public class BeMonotonic {
    //Solution933. Number of Recent Calls
    public static int ping(Queue<Integer> calls, int t) {
        int bound = t - 3000;
        while(!calls.isEmpty() && calls.peek() < bound) calls.poll();
        calls.offer(t);
        return calls.size();
    }

    //Solution739. Daily Temperatures: store indices instead of actual nums
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //* Get a number, we no longer care about any numbers in the stack smaller than it
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.push(i);
        }
        return ans;
    }

    //Solution239. Sliding Window Maximum
    public static int[] findAllMax(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1]; //*
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if (i - deque.getFirst() == k) { //*
                deque.removeFirst();
            }

            if (i >= k - 1) { //*
                ans[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return ans;
    }




//    public static int[] findAllMax(int[] nums, int k) {
//        int[] ans = new int[nums.length - k + 1]; //* total number of sliding window with length k over an array
//
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            //monotonic decreasing
//            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
//                deque.removeLast();
//            }
//            deque.addLast(i);
//
//            //preserve fixed length k
//            if (i - deque.getFirst() == k) {
//                deque.removeFirst();
//            }
//
//            //only add to the ans once initial window reached length k
//            if (i >= k - 1) ans[i - k + 1] = nums[deque.getFirst()];
//        }
//        return ans;
//    }

    public static void main(String[] args) {

    }
}
