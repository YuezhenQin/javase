package Hashing;

import java.util.*;

//Anytime you need to count anything, think about using a HashMap to do it.
public class Counting {
    //Solution560.


    // k distinct chars: Find the length of the longest substring that contains at most k distinct characters.
    public static int findSubstring(String str, int k) {
        Map<Character, Integer> counts = new HashMap<>();

        int ans = 0;

        int left = 0;

        int count = 0;

        for (int right = 0; right < str.length(); right++) {
            char added = str.charAt(right);
            count = counts.getOrDefault(added, 0);
            counts.put(added, count + 1);

            while (counts.size() > k) { //The length (number of keys) in counts at any time is the number of distinct characters.
                char removed = str.charAt(left);
                count = counts.getOrDefault(removed, 0);
                counts.put(removed, count - 1);
                if (counts.get(removed) == 0) counts.remove((removed));
                left ++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    // intersection of multiple arrays (Solution 2248):
    public static List<Integer> intersection(int[][] arrs) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] arr: arrs) {
            for (int num: arr) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int key: counts.keySet()) {
            if (counts.get(key) == arrs.length) ans.add(key);
        }
        Collections.sort(ans);
        return ans;
    }

    // equal number of occurrences (Solution 1941):
    public static boolean isNumberOfOccurrencesEqual(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char curr: str.toCharArray()) {
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        
        Set<Integer> freqs = new HashSet<>(counts.values());
        return freqs.size() == 1;
    }



    public static void main(String[] args) {

    }
}
