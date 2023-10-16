package 排序;

//QuickSort Partition

import java.util.Random;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Random rand = new Random();
        //第1大元素是第nums.length-1小元素
        //第k大元素是第nums.length-k小元素
        return selectK(nums, 0, nums.length - 1, nums.length - k, rand);
    }

    //在[left,right]的范围内求解 kth 并返回
    private int selectK(int[] arr, int left, int right, int k, Random rand) {
        //在[left,right]的范围内选择一个随机索引
        int p = partition(arr, left, right, rand);
        //k等于该索引
        if (k == p) return arr[p];
        //k小于该索引，到该索引的左侧找
        if (k < p) return selectK(arr, left, p - 1, k, rand);
        //k大于该索引，到该索引的左侧找
        return selectK(arr, p + 1, right, k, rand);
    }

    private int partition(int[] arr, int left, int right, Random rand) {
        //生成[left,right]之间的随机索引
        int p = rand.nextInt(right- left + 1) + left;
        swap(arr, left, p);
        //arr[left+1,i-1]<=v,arr[j+1,right]>=v
        int i = left + 1;
        int j = right;
        while(true) {
            while (i <= j && arr[i] < arr[left]) {
                i++;
            }
            while (j >= i && arr[j] > arr[left]) {
                j--;
            }
            if (i >= j) break;
            swap(arr, i, j);

            i++;
            j--;
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
