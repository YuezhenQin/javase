package SortingAlgorithm;

import java.util.Arrays;

public class HeapSort {
    private HeapSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e: data) {
            maxHeap.add(e);
        }
//        倒序赋值
        for (int i = data.length - 1; i >= 0; i --) {
            data[i] = maxHeap.extractMax();
        }
    }

//    public static <E extends Comparable<E>> void sort(E[] data, boolean isHeapify) {
//        //若size<=1，则无需进行排序。
//        if (data.length <= 1) return;
//        //从最后一个非叶子节点的索引开始，倒序向前对每一个节点的索引siftDown
//        if (isHeapify) {
//            for (int i = parent(data.length - 1); i >= 0; i--) {
//                siftDown(data, i, data.length);
//            }
//            for (int i = data.length - 1; i >= 0; i--) {
//                swap(data,0, i);
//                //对堆顶元素siftDown, [0.i)
//                siftDown(data, 0, i);
//            }
//        }
//    }
//
//    private static int parent(int k) {
//        if (k == 0) throw new IllegalArgumentException("");
//        return (k - 1) / 2;
//    }
//
//    private static int leftChild(int k) {
//        return k * 2 + 1;
//    }
//
////    private static int rightChild(int k) {
////        return k * 2 + 2;
////    }
//
//    private static   <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
//        //若左孩子尚未达到 n，则仍然存在左孩子
//        while (k * 2 + 1 < n) {
//            int left = leftChild(k);
//            //若存在右孩子且右孩子更大
//            if (left + 1 < n && data[left + 1].compareTo(data[left]) > 0) {
//                left ++;
//            }
//            //若 k节点 >= 左、右孩子中较大的一个，维持了堆的性质，则提前结束循环，无需交换。
//            if (data[k].compareTo(data[left]) >= 0) {
//                break;
//            }
//            swap(data, k, left);
//            k = left;
//        }
//    }
//
//    private static <E> void swap(E[] data, int i, int j) {
//        E tmp = data[i];
//        data[i] = data[j];
//        data[j] = tmp;
//    }



    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortingHelper.test("InsertionSort", arr1);
        SortingHelper.test("MergeSort", arr2);
        SortingHelper.test("QuickSort3ways", arr3);
        SortingHelper.test("HeapSort", arr4);
    }
}
