package Hashing.tmp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static Set<Integer> getDulpilcateElements(Integer[] arr1, Integer[] arr2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));

        for (Integer i: arr2) {
            if (!set1.add(i)) result.add(i);
        }
        return result;
    }
    //https://blog.csdn.net/u013278314/article/details/83182389

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

}
