package SortingAlgorithm;

import java.util.Arrays;

public class SelectionSort<E> {
    private SelectionSort() {};

    public static <E extends Comparable<E>> void sort(E data[]) {
        for (int i = 0; i < data.length; i++) {
            //选择arr[i..n)中用于存放最小值的索引
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if(data[j].compareTo(data[minIndex]) < 0) minIndex = j;
            }
            swap(i, minIndex, data);
        }
    }

    private static <E> void swap(int i, int minIndex, E data[]) {
        E tmp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = tmp;
    }



    public static void main(String[] args) {
//        Integer arr[] = {1,4,2,3,6,5,7};
//        SelectionSort.sort(arr);
//        System.out.println(Arrays.toString(arr));

        Person people[] = {
                new Person("Socrates", 1),
                new Person("Plato", 3),
                new Person("Aristotle", 2)
        };
        SelectionSort.sort(people);
        System.out.println(Arrays.toString(people));

        int sizes[] = {10000, 100000}; //第一轮与第二轮测试数据规模相差10倍,算法的性能相差...倍
        for (int size: sizes) {
            Integer arr[] = ArrayGenerator.generateRandomArray(size);
            SortingHelper.test("SelectionSort", arr);
        }
    }
}


//public class SelectionSort<E> {
//    private SelectionSort() {};
//    /* 带约束的泛型: <E extends Comparable<E>> 待排序的数据必须是Comparable的，必须实现Comparable接口 */
//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            /* 前半部分 arr[0,i) 已排序, 后半部分 arr[i,n)未排序, 第一轮循环arr[0,n)未排序 */
//            int minIndex = i;
//            for (int j = i; j < arr.length; j++) {
//                /* 选择未排序部分中的最小元素 */
//                if (arr[j].compareTo(arr[minIndex]) < 0)
//                    minIndex = j;
//            }
//            /* 与未排序部分的第一个元素交换位置 */
//            swap(arr, i, minIndex);
//        }
//    }
//    private static <E> void swap(E[] data, int i, int j) {
//        E tmp = data[i];
//        data[i] = data[j];
//        data[j] = tmp;
//    }
//
//    public static void main(String[] args) {
////        Integer[] arr = {10, 0, 1, -1, 5};
//
////        int size = 100000;
//        int[] sizes = {10000, 100000};
//        for (int size: sizes) {
//            Integer[] arr = ArrayGenerator.generateRandomArray(size);
//
//            SortingHelper.testSort("SelectionSort", arr);
//        }
////        long startTime = System.nanoTime();
////        SelectionSort.sort(arr);
////        long endTime = System.nanoTime();
////        double time = (endTime - startTime) / 1_000_000_000.0;
////
////        if (!SortingHelper.isSorted(arr)) throw new RuntimeException("SelectionSort unsuccessful");
////
////        System.out.println(time);
//
////        for (int a: arr) System.out.print(a + " ");
//
//        Person[] people = {new Person("a", 3), new Person("b", 1), new Person("c", 2)};
//        SelectionSort.sort(people);
//        System.out.println(Arrays.toString(people));
//
//    }
//}
