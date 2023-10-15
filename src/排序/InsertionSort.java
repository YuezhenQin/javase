package 排序;

import java.util.Arrays;

public class InsertionSort<E> {
    private InsertionSort() {}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) { //每次处理一个元素，将arr[i]这个元素插入到合适的位置

//            for (int j = i; j - 1 >= 0; j--) { //j索引从后向前遍历,不会访问i索引没有遍历到的元素
//                if (arr[j].compareTo(arr[j-1]) < 0) {
//                    swap(arr, j, j-1);
//                } else {
//                    break;
//                }
//            }

            //逻辑“与” && 连接循环终止条件，内层循环提前终止
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j-1]) < 0; j--) { //j索引从后向前遍历,不会访问i索引没有遍历到的元素
                swap(arr, j, j-1);
            }
        }
    }
    public static <E extends Comparable<E>> void sort_updated(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E tmp = arr[i]; //加入一个临时变量记录当前处理的元素，将arr[i]插入到合适的位置
            for (int j = i; j > 0; j--) {
                if (tmp.compareTo(arr[j - 1]) < 0) arr[j - 1] = arr[j]; //交换操作转换为赋值操作
                else {arr[j] = tmp; break;}
            }
        }
    }

    public static <E extends Comparable<E>> void sort_updated(E[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            E tmp = arr[i]; //加入一个临时变量记录当前处理的元素
            for (int j = i; j - 1 >= left; j--) {
                if (tmp.compareTo(arr[j - 1]) < 0) arr[j - 1] = arr[j]; //交换操作转换为赋值操作
                else {arr[j] = tmp; break;}
            }
        }
    }



    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i]; //寻址操作
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int sizes[] = {10000, 100000}; //第一轮与第二轮测试数据规模相差10倍,算法的性能相差...倍
        for (int size: sizes) {
            System.out.println("Random Array:");
            Integer[] arr = ArrayGenerator.generateRandomArray(size);
            Integer[] copied_arr = Arrays.copyOf(arr, arr.length); //
            SortingHelper.test("SelectionSort", arr);
            SortingHelper.test("InsertionSort", copied_arr);
            System.out.println();

            System.out.println("Ordered Array:");
            Integer[] ordered_arr = ArrayGenerator.generateOrderedArray(size);
            Integer[] copied_ordered_arr = Arrays.copyOf(arr, arr.length);
            SortingHelper.test("SelectionSort", ordered_arr);
            SortingHelper.test("InsertionSort", copied_ordered_arr);
            System.out.println();
        }

    }
}
