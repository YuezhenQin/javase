package SearchAlgorithm;

/*
* 二分查找: 对于一个有序数组，如果中间元素是要查找的元素，就返回它的索引; 若中间元素大于目标，则在中间元素的左侧继续查找；若中间元素小于目标，则在右侧继续查找
* 1.查找 t 的索引
* 2.求上界 upper_bound() 大于 t 的最小值的索引
* 3.求下界 lower_bound() 小于 t 的最大值的索引

* */

import java.util.Arrays;

public class BinarySearch <E> {
    //Solution704. binary search
    public static int binarySearch(int[] arr, int x) {
        // Define the current search space
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Half the search space at every iteration
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //Solution74. search a 2D matrix
    public static boolean binarySearchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
                continue;
            }
            if (matrix[mid][matrix[mid].length - 1] < target) {
                left = mid + 1;
                continue;
            }

            for (int i = 0; i < matrix[mid].length; i++) {
                if (matrix[mid][i] == target) return true;
            }
            return false;
        }
        return false;
    }

    //Solution35. search insertion point
    public int searchInsertionPoint(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) { //*
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] > target ? left: left + 1;
    }

    //Solution2389. longest subsequence with limited sum
    public int[] answerToQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] counts = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            int query = queries[i];
            for (int num: nums) {
                if (num <= query) {
                    count ++;
                    query -= num; //*
                } else {
                    break;
                }
            }
            counts[i] = count;
        }
        return counts;
    }

    public static int[] answerToQueries(int[] nums, int[] queries, boolean tmp) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int[] counts = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(prefix, queries[i]);
            counts[i] = index;
        }
        return counts;
    }


    //Solution875. Koko Eating Bananas
    public static int minimumSpeed(int[] piles, int h) {
        int limit = h;
        // define a search space
        int left = 1; // minimum possible answer
        int right = Arrays.stream(piles).max().getAsInt(); // maximum possible answer

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, piles, limit)) { // piles/k = exph <= h
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static boolean check(int k, int[] piles, int h) {
        int exph = 0;
        for (int pile: piles) {
            while (pile > 0) {pile = pile - k; exph++;}
        }
        return exph <= h;
    }
//    private static int geth(int[] piles, int k) {
//        int h = 0;
//        for (int pile: piles) {
//            while (pile > 0) {pile = pile - k; h++;}
//        }
//        return h;
//    }


    /* 非递归实现二分查找 */
    public static <E extends Comparable<E>> int search(E[] data, E target) {
         int left = 0;
         int right = data.length - 1; //int right = data.length;
         //在data[left, right]这个范围去寻找target, 在data[left, right)这个范围去寻找target
         while (left <= right) { // while (left < right)
             int mid = left + (right - left) / 2;
             if (data[mid].equals(target)) return mid;
             if (data[mid].compareTo(target) > 0) { //target在mid左侧, 修改右边界
                 right = mid - 1; // right = mid;
             } else { //target在mid右侧, 修改左边界
                 left = mid + 1;
             }
         }
         // left > right
         return -1;
    }

    /* 递归实现二分查找 */
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length -1, target);
    }
    private static <E extends Comparable<E>> int searchR(E[] data, int left, int right, E target) {
        //最基本问题的答案
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (data[mid].equals(target)) return mid;
        if (data[mid].compareTo(target) > 0) {
            return searchR(data, 0, mid - 1, target);
        } else {
            return searchR(data, mid + 1, right, target);
        }
    }

    //查找>target的最小值（找上界）
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int left = 0;
        int right = data.length;
        // data[left,right] 去求解
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (data[mid].compareTo(target) <= 0) { //mid小于等于target
                left = mid + 1;
            } else { //mid大于target
                right = mid;
            }
        }
        return left; //left==right
    }

    //查找<target的最大值（找下界）
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int left = -1;
        int right = data.length - 1;
        while (left < right) {
//            System.out.println(left + " " + right);
            int mid = (right - left + 1) / 2 + left; //调整 mid 的计算逻辑 (向上取整)
            //若left与right相邻, 则出现搜索空间不再改变的情况
            if (data[mid].compareTo(target) < 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

//    //返回==target的最大索引或大于target的最小值
//    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target) {
//        int u = upper(data, target);
//        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
//            //存在target
//            return u - 1;
//        }
//        //不存在target
//        return u;
//    }
//
//    //返回==target的最小索引或小于target的最大值
//    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
//        return -1;
//    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,3,3,5,5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upper(arr, i) + " ");
        }
        System.out.println();
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lower(arr, i) + " ");
        }
        System.out.println();
    }
}
