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
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        //算法的正确性判断
        if (!SortingHelper.isSorted(arr)) throw new RuntimeException(name + " failed.");
        //算法的复杂度分析
        System.out.println(String.format("%s, n=%d: in %f", name, arr.length, time));
    }

    //1.选择排序(SelectionSort) 稳定n^2
    //2.插入排序(InsertionSort) 数据有序或近乎有序(极少数数据处于无序状态) n, 数据无序 n^2
    //3.
}

