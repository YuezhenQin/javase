/* 基于比较的排序算法
 *                worst, avg, best
 * SelectionSort, O(n^2)
 * InsertionSort, O(n^2)      O(n)
 * */

public class SortingHelper {
    private SortingHelper() {};

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) return false;
        }
        return true;
    }

    public static <E extends Comparable<E>>void testSort(String sortName, E[] arr) {

        /* performance */
        long startTime = System.nanoTime();

        /* 反射机制 */
        if (sortName.equals("SelectionSort")) SelectionSort.sort(arr);
        else if (sortName.equals("InsertionSort")) InsertionSort.sort(arr);
        else if (sortName.equals("InsertionSortNew")) InsertionSort.sortNew(arr);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1_000_000_000.0;
        /* correctness */
        if (!SortingHelper.isSorted(arr)) throw new RuntimeException(sortName + " unsuccessful");
        System.out.println(String.format("%s, size = %d : %f s", sortName, arr.length, time));
    }


}
