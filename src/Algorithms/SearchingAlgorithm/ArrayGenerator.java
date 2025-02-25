package Algorithms.SearchingAlgorithm;

import java.util.Random;

/* 2.9 */
public class ArrayGenerator {
    private ArrayGenerator(){}
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = i;
        }
        return arr;
    }
    public static Integer[] generateRandomArray(int n) {
        Integer[] arr = new Integer[n];
        Random rand = new Random();
        for (int i =0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}
