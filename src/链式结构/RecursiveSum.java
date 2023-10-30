package 链式结构;
//递归

public class RecursiveSum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //calculate the sum of arr[i,n)
    private static int sum(int[] arr, int left) {
        if (left == arr.length) return 0; //最基本问题的答案 空数组
        int x = sum(arr, left + 1);
        int result = arr[left] + x;
        return result;
//        return arr[left] + sum(arr, left + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(sum(nums));
    }
}
