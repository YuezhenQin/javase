package Hashing;

import java.util.*;

//Hashing:
//HashMap (Dictionary)
//HashSet
public class CheckingForExistence {
    //Solution 1. Two Sum
    //Given an array of integers nums and an integer target, return indices of two numbers such that they add up to target.
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
    //Solution 2351. First Letter to Appear Twice
    public static char repeatCharacter(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) return c;
            set.add(c);
        }
        return ' ';
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

    //Solution 1832. Check if the Sentence Is Pangram
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

    public static void main(String[] args) {
        System.out.println(isPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(isPangram("leetcode"));
    }
}
