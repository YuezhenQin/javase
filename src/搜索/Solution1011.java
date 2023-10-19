package 搜索;

//BinarySearch 搜索出传送带的运载能力
//1.假设
//2.载重越大，时间越短
//3.界定搜索空间，计算最低取值和最高取值


import java.util.Arrays;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getDays(weights, mid) <= days) {
                right = mid; //mid是一个可行解，但我们还要找最优解
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int getDays(int[] weights, int k) {
        //curr是传送带当前载重
        int curr = 0;
        int result = 0;

        //遍历weights中的每一个元素weight
        for (int weight: weights) {
            //若传送带当前载重+新的载重<=传送带最大载重
            if (curr + weight <= k) {
                curr += weight;
            } else {
                result++; //需要新的一天
                curr = weight; //将传送带当前载重设置为新的载重
            }
        }
        result++;
        return result;
    }
}
