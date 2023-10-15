package 排序;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private QuickSort() {}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        //递归过程中需要指定待处理区间
        sort(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {
        if (left >= right) return;
        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }
    private static <E extends Comparable<E>> int partition(E[] arr, int left, int right) {
        //生成一个 [left,right] 的随机索引 (生成一个 [0, right-left] 的随机索引)
        int p = (new Random()).nextInt(right - left + 1) + left;
        swap(arr, left, p);

        //将数组划分成两部分，分别维持着一个循环不变量
        //arr[left+1, mid] < v, arr[mid+1, i] >= v
        int mid = left;

        //arr[i](当前被处理元素)
        for (int i = left + 1; i <= right; i++) {
            if (arr[i].compareTo(arr[left]) < 0) {
                mid ++;
                swap(arr, i, mid);
            }
        }
        swap(arr, left, mid);
        return mid;
    }
    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        //递归过程中需要指定待处理区间
        sort2ways(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort2ways(E[] arr, int left, int right) {
        if (left >= right) return;
        int p = partition2ways(arr, left, right);
        sort2ways(arr, left, p - 1);
        sort2ways(arr, p + 1, right);
    }
    private static <E extends Comparable<E>> int partition2ways(E[] arr, int left, int right) {
        int p = (new Random()).nextInt(right - left + 1) + left;
        swap(arr, left, p);
        //arr[left+1, i-1] <= v, arr[j+1, right] >= v
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[left]) < 0) { //循环继续条件是compareTo的结果<0, 循环终止条件是compareTo的结果>=0
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[left]) > 0) {
                j--;
            }
            if (i >= j) break;

            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, left, j);
        return j;
    }

    public static void main(String[] args) {
        int size = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(size);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        SortingHelper.test("MergeSort", arr1);
        SortingHelper.test("QuickSort", arr2);
        SortingHelper.test("QuickSort2ways", arr3);

        //快速排序问题1: 完全有序数组 左区间没有元素，右区间有n-1个元素
        arr1 = ArrayGenerator.generateOrderedArray(size);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        SortingHelper.test("MergeSort", arr1);
        SortingHelper.test("QuickSort", arr2);
        SortingHelper.test("QuickSort2ways", arr3);

        //快速排序问题2: 包含大量重复元素的数组
        arr1 = ArrayGenerator.generateRandomArray(size, 1);
        arr2 = Arrays.copyOf(arr1, arr1.length);
//        SortingHelper.test("QuickSort", arr1);
        SortingHelper.test("QuickSort2ways", arr1);
    }
}
