package 排序;

public class SortingHelper {
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0) return false;
        }
        return true;
    }

    //算法的评价 (关注复杂度级别的优化)
    public static <E extends Comparable<E>>void test(String name, E[] arr) {
        long startTime = System.nanoTime();
        if (name.equals("SelectionSort")) {SelectionSort.sort(arr); //选择排序: 选择未排序部分中的最小值，（向后比较）根据最小值元素所在索引与索引i对应的元素交换位置
        } else if (name.equals("InsertionSort")) {//插入排序: 每次处理一张牌，（向前比较）将这张牌插入到之前已经排好序的牌堆之中
            InsertionSort.sort(arr);
        } else if (name.equals("InsertionSortUpdated")) {
            InsertionSort.sort_updated(arr);
        } else if (name.equals("MergeSort")) {
            MergeSort.sort(arr);
        } else if (name.equals("MergeSortUpdated")) {
            MergeSort.sort_updated(arr);
        } else if (name.equals("QuickSort")) {
            QuickSort.sort(arr);
        } else if (name.equals("QuickSort2ways")) {
            QuickSort.sort2ways(arr);
        } else if (name.equals("QuickSort3ways")) {
            QuickSort.sort3ways(arr);
        } else if (name.equals("HeapSort")) {
            HeapSort.sort(arr);
        } else if (name.equals("BubbleSort")) {
            BubbleSort.sort(arr);
        } else if (name.equals("ShellSort")) {
            ShellSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        //算法的正确性判断
        if (!SortingHelper.isSorted(arr)) throw new RuntimeException(name + " failed.");
        //算法的复杂度分析
        System.out.println(String.format("%s, n=%d: in %f", name, arr.length, time));
    }

    //1.选择排序(SelectionSort) 稳定 n^2
    //2.插入排序(InsertionSort) 数据无序 n^2, 数据近乎有序 n
    //3.归并排序(MergeSort) 数据无序 nlogn, 数据近乎有序(极少数数据处于无序状态) n, 必须开辟新的空间(NOT in-place)
    //4.快速排序(QuickSort) nlogn 本质是一个随机算法, partition 是随机的;
    //5.堆排序(HeapSort) nlogn 作用不在于排序而在于构建优先队列
    //6.逆序紧邻对排序(BubbleSort) n^2 由前至后不断地消除逆序紧邻对，每轮最大值由前至后传递
    //7.希尔排序(ShellSort)与超参数 介于 O(nlogn), O(n^2) 之间 “分组”的思想: 将数据分为 h 个子数组，子数组之间间隔为 h，h不断缩小最终为1，不同的步长序列的选择，性能也不尽相同。

    //注意特殊的数据会影响算法的性能（random, sorted, reversed, most the same）
    //https://www.toptal.com/developers/sorting-algorithms

}

