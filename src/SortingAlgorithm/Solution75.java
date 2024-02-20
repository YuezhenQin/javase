package SortingAlgorithm;

//QuickSort3ways

public class Solution75 {
    public void sortColors(int[] nums) {
        //nums[0, lt] < v, nums[lt+1,i] == v, nums[gt,n-1] > v
        int lt = -1;
        int i = 0;
        int gt = nums.length;
        while (i < gt) {
             if (nums[i] == 0) {
                 lt++; //扩大左区间
                 swap(nums, i, lt);
                 i++;
             } else if (nums[i] == 2) {
                 gt--; //扩大右区间
                 swap(nums, i, gt);
             } else {
                 i++; //扩大中区间
             }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sortColors(int[] nums, boolean tmp) {
        int[] cnt = new int[3];
        for (int num: nums) {
            cnt[num] ++;
        }
    }


    public static void main(String[] args) {


    }
}
