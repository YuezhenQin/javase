

import java.util.Arrays;

public class SelectionSort <E> {
    private SelectionSort() {};
    /* 带约束的泛型: <E extends Comparable<E>> 待排序的数据必须是Comparable的，必须实现Comparable接口 */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            /* 前半部分 arr[0,i) 已排序, 后半部分 arr[i,n)未排序, 第一轮循环arr[0,n)未排序 */
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                /* 选择未排序部分中的最小元素 */
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            /* 与未排序部分的第一个元素交换位置 */
            swap(arr, i, minIndex);
        }
    }
    private static <E> void swap(E[] data, int i, int j) {
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
//        Integer[] arr = {10, 0, 1, -1, 5};

//        int size = 100000;
        int[] sizes = {10000, 100000};
        for (int size: sizes) {
            Integer[] arr = ArrayGenerator.generateRandomArray(size);

            SortingHelper.sortTest("SelectionSort", arr);
        }
//        long startTime = System.nanoTime();
//        SelectionSort.sort(arr);
//        long endTime = System.nanoTime();
//        double time = (endTime - startTime) / 1_000_000_000.0;
//
//        if (!SortingHelper.isSorted(arr)) throw new RuntimeException("SelectionSort unsuccessful");
//
//        System.out.println(time);

//        for (int a: arr) System.out.print(a + " ");

        Person[] people = {new Person("a", 3), new Person("b", 1), new Person("c", 2)};
        SelectionSort.sort(people);
        System.out.println(Arrays.toString(people));

    }
}
