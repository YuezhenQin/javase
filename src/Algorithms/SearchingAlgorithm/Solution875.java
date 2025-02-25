package Algorithms.SearchingAlgorithm;

//BinarySearch 二分查找的方式搜索求解

import java.util.Arrays;
//速率越大，时间越短

//使得 getTotalTime(mid)<=h 的 min(getTotalTime) 对应的 mid
public class Solution875 {
    public int minSpeed(int[] piles, int h) {
        int left = 1; //k 的最低取值
        int right = Arrays.stream(piles).max().getAsInt(); //k 的最高取值
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (getTotalTime(piles, mid) <= h) { //速率是mid, 总计时间为getTotalTime(mid)
                right = mid; //小于等于h, 速率可以慢一些
            } else {
                left = mid + 1; //超过h, 需要速率快一些
            }
        }
        return left;
    }
    private int getTotalTime(int[] piles, int k) {
        int result = 0;
        for (int pile: piles) {
            /* */
            result += pile / k + (pile % k > 0 ? 1 : 0);
        }
        return result;
    }
}
