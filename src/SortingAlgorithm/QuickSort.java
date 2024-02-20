package SortingAlgorithm;

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
        //选定一个p，将数据整理成三部分
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

    /**********************************************************/
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

    /**********************************************************/
    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        Random rand = new Random();
        sort3ways(arr, 0, arr.length - 1, rand);
    }
    private static <E extends Comparable<E>> void sort3ways(E[] arr, int left, int right, Random rand) {
        if (left >= right) return;

        //生成[left,right]之间的随机索引与最左边的元素交换位置
        int p = rand.nextInt(right - left + 1) + left;
        swap(arr, left, p);

        //arr[left + 1, lt] < v, [lt+1, i-1] ==v, [gt, right] > v
        int lt = left; //左边界大于右边界，空区间
        int i = left + 1; //左边界大于右边界，空区间
        int gt = right + 1; //右边界小于左边界，空区间

        //不是for()而是while()，不一定每一轮i都++
        while (i < gt) {
            if (arr[i].compareTo(arr[left]) < 0) {
                lt ++; //扩充左区间(<v)
                swap(arr, i, lt);
                i ++;
            } else if (arr[i].compareTo(arr[left]) > 0) {
                gt --; //扩充右区间(>v)
                swap(arr, i, gt);
            } else {
                i++; //扩充中区间 (=v 避免了对这部分的递归)
            }
        }
        //arr[left, lt - 1] < v, arr[lt, gt-1] ==v, arr[gt, right] > v
        swap(arr, left, lt);
        sort3ways(arr, left, lt - 1, rand);
        sort3ways(arr, gt, right, rand);
    }


    public static void main(String[] args) {
        int size = 1000000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(size);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortingHelper.test("MergeSort", arr1);
        SortingHelper.test("QuickSort", arr2);

        //快速排序问题1: 完全有序数组 左区间没有元素，右区间有n-1个元素
        arr1 = ArrayGenerator.generateOrderedArray(size);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        SortingHelper.test("MergeSort", arr1);
        SortingHelper.test("QuickSort", arr2);
        SortingHelper.test("QuickSort2ways", arr3);
        SortingHelper.test("QuickSort3ways", arr4);

        //快速排序问题2: 包含大量重复元素的数组
        arr1 = ArrayGenerator.generateRandomArray(size, 1);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortingHelper.test("QuickSort", arr1);
        SortingHelper.test("QuickSort2ways", arr2);
        SortingHelper.test("QuickSort3ways", arr3);
    }
}
