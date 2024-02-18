package Arrays_and_strings;

import java.util.Arrays;

public class TwoPointers {

    /*
    * Two pointers is an extremely common technique used to solve array and string problems.
    * It involves having two integer variables that both move along an iterable.
    * This means we will have two integers, usually named something like i and j, or left and right which each represent an index of the array or string.
    * */

    //Example 1: Given a string s, return true if it is a palindrome, false otherwise.
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }

    //Example 2: Given a sorted array of unique integers and a target integer, return true if there exists a pair of numbers that sum to target, false otherwise. This problem is similar to Two Sum. (In Two Sum, the input is not sorted).
    public static boolean hasTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return true;
            } else if (nums[left] + nums[right] > target) {
                right --;
            } else {
                left ++;
            }
        }
        return false;
    }

    //Example 3: Given two sorted integer arrays arr1 and arr2,
    //return a new array that combines both of them and is also sorted.
    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] newArr = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                newArr[k] = arr1[i];
                i++;
                k++;
            } else {
                newArr[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < arr1.length) {
            newArr[k] = arr1[i];
            i ++;
            k ++;
        }
        while (j < arr2.length) {
            newArr[k] = arr2[j];

            j ++;
            k ++;
        }
        return newArr;
    }

    //Example 4: 392. Is Subsequence.
    //Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i ++;
            }
            j ++;
        }
        return i == s.length();
    }

    //Example 5: Reversing String (344)
    public static char[] reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            swap(left, right, chars);
            left ++;
            right --;
        }
        return chars;
    }

    public static void reverseString(char[] chars) {
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

    private static void swap(int left, int right, char[] chars) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome("LOL"));
        System.out.println(isPalindrome("radar"));
        System.out.println(isPalindrome("test"));
        System.out.println();
        int[] nums = new int[]{1,2};
        int[] arr1 = {1,3,5,7,99};
        int[] arr2 = {2,4,8,108};
        int[] newArr = merge(arr1, arr2);
        System.out.println(Arrays.toString(newArr));

        System.out.println(isSubsequence("absc", "abcde"));

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        System.out.println(reverse(vowels));
    }
}
