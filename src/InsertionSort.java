import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {

        /* 每一轮循环处理一个元素 arr[i], 从后向前，将其插入到已排序部分中的一个合适的位置  */
        for (int i = 0; i < arr.length; i++) {
            /* arr[0,i) 已排序（与选择排序不同，已排序部分不一定是最终排序结果）, arr[i,n)未排序, 第一轮循环arr[0,n)未排序 */

            /* 为了找到这个合适的位置, 设置一个新的索引j, 从i开始, 从后向前比较 */
            /* 循环终止条件简化前 */
//            for (int j = i; j - 1 >= 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) swap(arr, j, j - 1);
//                else break;
//            }
            /* 循环终止条件简化后 */
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j-1]) < 0; j--) { //是否应放在该位置(j)取决于该位置的前一个位置(j-1)
                swap(arr, j, j - 1);
            }
        }
    }
    public static <E extends Comparable<E>> void sortNew(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E tmp = arr[i];

            int j;
            for (j = i; j - 1 >= 0 && tmp.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

        private static <E> void swap(E[] data, int i, int j) {
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] sizes = {10000, 100000};
        for (int size: sizes) {
            Integer[] arr = ArrayGenerator.generateRandomArray(size);
            Integer[] arrNew = Arrays.copyOf(arr, arr.length);

//            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("InsertionSortNew", arrNew);

            System.out.println("Random array:");
            Integer[] randomArr = ArrayGenerator.generateRandomArray(size);
            Integer[] randomArrNew = Arrays.copyOf(randomArr, randomArr.length);
            SortingHelper.sortTest("SelectionSort", randomArr);
            SortingHelper.sortTest("InsertionSortNew", randomArrNew);
            System.out.println();

            System.out.println("Ordered array:");
            Integer[] orderedArr = ArrayGenerator.generateOrderedArray(size);
            Integer[] orderedArrNew = Arrays.copyOf(orderedArr, orderedArr.length);
            SortingHelper.sortTest("SelectionSort", orderedArr);
            SortingHelper.sortTest("InsertionSortNew", orderedArrNew);
            System.out.println();
        }
    }
}
