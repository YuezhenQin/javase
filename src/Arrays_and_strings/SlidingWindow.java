package Arrays_and_strings;

public class SlidingWindow {
    //Example 1: find the length of the longest subarray of an array.
    public static int findLengthOfTheLongestSubarray(int[] arr, int k) {
        int left = 0;
        int curr = 0; // the current sum of the window
        int length = 0;
        for (int right = 0; right < arr.length; right ++) {
            curr += arr[right];

            while (curr > k) {
                curr -= arr[left];
                left ++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    //Example 2:
    public static int findLengthOfLongestSubstring(String str) {
        int left = 0;
        int curr = 0;
        int result = 0;

        for (int right = 0; right < str.length(); right ++) {
            if (str.charAt(right) == '0') curr ++;
            while (curr > 1) {
                if (str.charAt(left) == '0') curr --;
                left ++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    //

    // Solution 1004. Max Consecutive Ones |||
    public static int longestOnes(int[] nums, int k) {
        int length = 0;

        int zeros = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right ++) {
            if (nums[right] == 0) zeros ++;

            while (zeros > k) {
                if (nums[left] == 0) zeros --;
                left ++;
            }
            length = Math.max(right - left + 1, length);
        }
        return length;
    }

    public static int findLengthOfLongestOnes(int[] nums, int k) {
        int zeros = 0;

        int length = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right ++) {
            if(nums[right] == 0) zeros ++;

            while (zeros > k) {
                if (nums[left] == 0) zeros --;
                left ++;
            }

            length = Math.max(length, right - left + 1); //*
        }
        return length;
    }

    //Example 3: Number of subarray that product less than k (Solution713)
    public static int findNumOfSubarray(int[] arr, int k) {
        int left = 0;
        int curr = 1;
        int result = 0;
        for (int right = 0; right < arr.length; right++) {
            curr *= arr[right];

            while (curr > k) {
                curr /= arr[left];
                left ++;
            }
            //The number of valid windows ending at index right is equal to the size of the window,
            //... which we know is right - left + 1
            result += right - left + 1;
        }
        return result;
    }

    //Solution643: Maximum Average Subarray
    public static double findMaxAverage(int[] arr, int k) {
        // calculate initial sliding window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;

        //slide the window from left to right, by add arr[right] and remove arr[left]
        int left = 0;
        for (int right = k; right < arr.length; right++) {
//            sum = sum + arr[right] - arr[left];
            sum += arr[right];
            sum -= arr[left];
            max = Math.max(sum, max);

            left ++;
        }
        return (double) max / k;
    }




    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int result = findLengthOfTheLongestSubarray(arr, 8);
        System.out.println(result);
        String str = "1101100111";
        System.out.println(findLengthOfLongestSubstring(str));
        int[] input = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(input, 4));
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(findLengthOfLongestOnes(nums1, 2));
        System.out.println(longestOnes(nums1, 2));
        System.out.println(findLengthOfLongestOnes(nums2, 3));
        System.out.println(longestOnes(nums2, 3));


    }
}
