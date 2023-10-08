package 排序;

public class InsertionSort<E> {
    private InsertionSort() {}
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) { //j索引从后向前遍历,不会访问i索引没有遍历到的元素
                if (arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int sizes[] = {10000, 100000}; //第一轮与第二轮测试数据规模相差10倍,算法的性能相差...倍
        for (int size: sizes) {
            Integer arr[] = ArrayGenerator.generateRandomArray(size);
            SortingHelper.test("InsertionSort", arr);
        }
    }
}
