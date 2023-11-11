package 排序;

import java.util.Arrays;

public class BubbleSort<E> {
    private BubbleSort(){}

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i-1; j < data.length - 1; j++) {
                if (data[i-1].compareTo(data[i]) > 0) {
                    E tmp = data[i-1];
                    data[i-1] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5,1,4,2,5,3,6,8,0};
        BubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
