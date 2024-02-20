package SortingAlgorithm;
import java.util.Arrays;

//冒泡排序
//重难点是循环的终止条件
public class BubbleSort<E> {
    private BubbleSort(){}

    //由前至后，不断减少逆序对，第一轮循环保证了最后一个元素已排序
    public static <E extends Comparable<E>> void sort(E[] data) {
        //i表示冒泡排序的轮数，共n-1轮循环，因为最后一轮循环只剩余一个元素了，也就不存在相邻的两个元素的概念了
        for (int i = 0; i < data.length - 1; i++) {
            //arr[n-i,n)已排序，在 arr[n-i-1]这个位置放置合适的元素
            for (int j = 0; j + 1 <= data.length - i - 1; j++) {
                //j, j+1
                if (data[j].compareTo(data[j+1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    //记录内层循环中是否发生了交换
    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = 0; i + 1 < data.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j + 1 <= data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    //记录内层循环中最后交换的位置发生在哪里
    public static <E extends Comparable<E>> void sort3(E[] data) {
        for (int i = 0; i + 1 < data.length; ) {
            int lastSwapIndex = 0;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwapIndex = j + 1;
                }
            }
//            if (lastSwapIndex == 0) break;
            i = data.length - lastSwapIndex;
        }
    }

    //一个交换操作背后有三条指令
    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortingHelper.test("BubbleSort", arr1);
        SortingHelper.test("BubbleSort2", arr2);
        SortingHelper.test("BubbleSort3", arr3);

        System.out.println(BubbleSort.class);
    }
}
