package Hashing;

import java.util.*;

//Hashing:
//HashMap (Dictionary): Counting
//HashSet: Add,Remove,and Check if an element exists; Repetition; Grouping

public class CheckingForExistence {
    //Solution1. Two Sum: Get indices of two numbers such that they add up to target.
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (dict.containsKey(complement)) return new int[]{i, dict.get(complement)};
            dict.put(num, i);
        }
        return new int[]{-1,-1};
    }

    public static List<Integer> findAll(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1) && !set.contains(num + 1)) list.add(num);
        }

        return list;
    }

    //Solution1832. Check if the Sentence Is Pangram
    public static boolean isPangram(String sentence) {
        Set<Character> alphabet = new HashSet<>();
        for (char curr = 'a'; curr <= 'z'; curr++) {
            alphabet.add(curr);
        }

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            charSet.add(sentence.charAt(i));
        }

        return charSet.containsAll(alphabet);
    }


    //Solution2351. First Letter to Appear Twice
    public static char repeatCharacter(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) return c;
            set.add(c);
        }
        return ' ';
    }

    //Solution2260. Minimum Consecutive Cards to Pick Up
    public static int findLengthOfShortestSubarrayContainsAtLeastOneDulplicate(int[] nums) {
        int length = Integer.MAX_VALUE;

        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i]))
                length = Math.min(length, Math.abs(dict.get(nums[i]) - i) + 1); //right - left + 1

            dict.put(nums[i], i);
        }
        return (length == Integer.MAX_VALUE) ? -1: length;
    }

    //Solution2342:
    public static int findMaxDigitSum(int[] nums) {
        int max = -1;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (dict.containsKey(digitSum)) {
                max = Math.max(max, num + dict.get(digitSum));
            }
            dict.put(digitSum, Math.max(num, dict.getOrDefault(digitSum, 0)));
        }
        return max;
    }

    private static int getDigitSum(int num) {
        //法一: 二次转换
//        char[] chars = Integer.toString(num).toCharArray();
//        int sum = 0;
//        for (char c: chars) {
//            sum += c;
//        }
        //法二：除10取余
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }

        return digitSum;
    }

    //Solution2352. Equal Row and Column Pairs


    public static void main(String[] args) {
        System.out.println(isPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(isPangram("leetcode"));
        int[] nums = {3,4,2,3,4,7};
//        int[] nums = {3};
        int length = findLengthOfShortestSubarrayContainsAtLeastOneDulplicate(nums);
        System.out.println(length);

        nums = new int[]{383,77,97,261,102,344,150,130,55,337,401,498,21,5};
        System.out.println(findMaxDigitSum(nums));
    }
}
