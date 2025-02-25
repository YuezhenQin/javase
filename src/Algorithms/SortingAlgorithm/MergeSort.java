package Algorithms.SortingAlgorithm;

/*
* 归并排序
* mergeSort(arr, left, right) {
*     if (left >= right) return;
*     merge(arr, left, mid);
*     merge(arr, mid+1, right);
*     merge(arr,  left, mid, right);
* */

//top down 自顶向下
//bottom up 自底向上

import java.util.Arrays;

public class MergeSort {
    //递归函数的宏观语义: 设立一个mergeSort函数，这个函数有三个参数: arr, left和right。arr是待处理的数组，left和right分别是数组从索引为left到索引为right这部分，前闭后闭的子区间进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0 , arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {
        //最基本问题的答案 (没有元素 或者 只有一个元素 都不需要排序)
        if (left > right || left == right) return;
        //将区间一分为二为左、右两个更小的区间
//        int mid = (left + right) / 2; //32位整型相加存在溢出的可能 (上亿级别规模)
        int mid = left + (right - left) / 2;
        sort(arr, left, mid); //对左区间排序
        sort(arr, mid + 1, right); //对右区间排序
        //将左右区间 arr[left, mid]和arr[mid+1, right]合并
        merge(arr, left, mid, right);
    }

    //左、右两个有序区间的合并
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right) {
        //必须开辟出新的空间
        //E[] arr 索引从 left 开始到 right 结束, E[] tmp 索引从 0 开始
        E[] tmp = Arrays.copyOfRange(arr, left, right + 1);
        int i = left; //左区间的索引
        int j = mid + 1; //右区间的索引
        //对 arr[k] 赋值
        for (int k = left; k <= right; k++) {
            if (i > mid) { //i已经越界，左区间不再有元素了
                arr[k] = tmp[j - left]; //偏移量为 left
                j ++;
            } else if (j > right) { //j已经越界, 右边的区间中元素被处理完了
                arr[k] = tmp[i - left];
                i ++;
            } else if (tmp[i - left].compareTo(tmp[j - left]) <= 0) {//i与j都没有越界
                arr[k] = tmp[i - left];
                i ++;
            } else {
                arr[k] = tmp[j - left];
                j++;
            }
        }
    }

    public static <E extends Comparable<E>> void sort_updated(E[] arr) {
        //针对内部存储操作优化，只开辟一次临时空间
        E[] tmp = Arrays.copyOf(arr, arr.length);
        sort_updated(arr, 0 , arr.length - 1, tmp);
    }
    private static <E extends Comparable<E>> void sort_updated(E[] arr, int left, int right, E[] tmp) {
        //针对递归终止条件优化 若数据规模较小，则使用选择/插入排序
        if (right - left < 16) {
            InsertionSort.sort_updated(arr, left, right);
            return; //需要return
        }

        int mid = left + (right - left) / 2;
        sort_updated(arr, left, mid, tmp);
        sort_updated(arr, mid + 1, right, tmp);
        //若左区间的最后一个元素<=右区间的第一个元素，则merge()不执行（仅计算有多少个节点: 非叶子节点的数量 n/2+n/4+...+1<n, 叶子结点的数量 n, 总计 <2n = O(n)）
        if (arr[mid].compareTo(arr[mid + 1]) > 0) merge_updated(arr, left, mid, right, tmp);
    }

    private static <E extends Comparable<E>> void merge_updated(E[] arr, int left, int mid, int right, E[] tmp) {
        System.arraycopy(arr, left, tmp, left, right - left + 1);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = tmp[j];
                j ++;
            } else if (j > right) {
                arr[k] = tmp[i];
                i ++;
            } else if (tmp[i].compareTo(tmp[j]) <= 0) {
                arr[k] = tmp[i];
                i ++;
            } else {
                arr[k] = tmp[j];
                j++;
            }
        }
    }

    //自底向上
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] tmp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;

        //遍历合并的区间长度
        for (int size = 1; size < n; size += size) {
            //遍历起始位置i, 合并arr[i, i+size-1]和[i+size,Math.min(i+size+size-1,n-1)]
            for (int i = 0; i + size < n;i += size * 2) {
                merge(arr, i, i + size - 1, Math.min(i + size + size -1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        int size = 5000000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(size);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
//        SortingHelper.test("SelectionSort", arr1);
//        SortingHelper.test("InsertionSort", arr2);
        SortingHelper.test("MergeSort", arr3);
        SortingHelper.test("MergeSortUpdated", arr4);
    }
}
