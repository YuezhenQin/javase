package Algorithms.SearchingAlgorithm;

public class Solution704 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
    private int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            return search(nums, left, mid - 1, target);
        } else {
            return search(nums, mid + 1, right, target);
        }
    }
}
