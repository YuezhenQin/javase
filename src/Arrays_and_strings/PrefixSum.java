package Arrays_and_strings;

import java.util.Arrays;

public class PrefixSum {
    public static boolean[] answerToQueries(int[] nums, int[][] queries, int limit) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int sum = prefix[right] - prefix[left] + nums[left];
            ans[i] = sum < limit;
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {1,6,3,2,7,2};
        int[][] queries = {{0,3}, {2,5}, {2,4}};
        int limit = 13;
        System.out.println(Arrays.toString(answerToQueries(nums, queries, limit)));
    }
}
