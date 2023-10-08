package 排序;

public class SortingHelper {
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0) return false;
        }
        return true;
    }

    //算法的评价
    public static <E extends Comparable<E>>void test(String name, E[] arr) {
        long startTime = System.nanoTime();
        if (name.equals("SelectionSort")) {SelectionSort.sort(arr); //选择排序: 选择未排序部分中的最小值，（向后比较）根据最小值元素所在索引与索引i对应的元素交换位置
        } else if (name.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        } //插入排序: 每次处理一张牌，（向前比较）将这张牌插入到之前已经排好序的牌堆之中。

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        //算法的正确性
        if (!SortingHelper.isSorted(arr)) throw new RuntimeException(name + " failed.");
        //算法的复杂性
        System.out.println(String.format("%s, n=%d: in %f", name, arr.length, time));
    }
}

