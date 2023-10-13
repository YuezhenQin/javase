package 排序;

//合并排序

public class MergeSort {
    //递归函数的宏观语义: 设立一个mergeSort函数，这个函数有三个参数: arr, left和right。arr是待处理的数组，left和right分别是数组从索引为left到索引为right这部分，前闭后闭的子区间进行排序
    public void mergeSort(int[] arr, int left, int right) {
        if (left > right || left == right) return; //最基本问题的答案

        int mid = (left + right) / 2;
        //递归调用第一次
        mergeSort(arr, left, mid);
        //递归调用第二次
        mergeSort(arr, mid + 1, right);

        //将arr[left, mid]和arr[mid+1, right]合并
        merge(arr, left, mid, right);
    }

    //如何合并?
    private void merge(int[] arr, int left, int mid, int right) {


    }
}
