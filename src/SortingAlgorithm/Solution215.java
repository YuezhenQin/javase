package SortingAlgorithm;

//找到第k大/第k小的元素: 用

//在n个元素中找到最小的k个元素: 用最大堆维护k个最小的元素，若新的数据比k个最小元素中的最大值还小，则替换

import java.util.PriorityQueue;
import java.util.Random;

public class Solution215 {
//    public int findKthLargest(int[] nums, int k) {
//        Random rand = new Random();
//        //第1大元素是第nums.length-1小元素
//        //第k大元素是第nums.length-k小元素
//        return selectK(nums, 0, nums.length - 1, nums.length - k, rand);
//    }

    //非递归实现 selectK()
    private int selectK(int[] arr, int k, Random rand) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
           int p = partition(arr, left, right, rand);
           if (p == k) return p;
           if (p > k) {
               right = p - 1;
           } else {
               left = p + 1;
           }
        }
        // left > right
        return -1; //k不在[0, nums.length-1]的之内
    }

    //递归实现 selectK(), 在[left,right]的范围内求解k并返回
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

    public int findKthLargest(int[] nums, int k) {
        //将前面的k个元素加入优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        //pq的底层是最小堆
        for (int i = k; i < nums.length; i++) {
            //若pq不为空且当前元素大于优先队列队首元素（比最大的k个元素中最小的元素 大）
            if (!pq.isEmpty() && nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {

    }
}
