package SortingAlgorithm;

public class ShellSort {
    private ShellSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        //初始间隔
        int h = data.length / 2;
        while (h >= 1) {
            //start是各个子数组起始的元素索引
            for (int start = 0; start < h; start ++) {
                //插入排序, 将data[i]插入到合适的位置
                for (int i = start + h; i < data.length; i += h) {
                    E tmp = data[i];
                    int target;
                    //target的前一个元素是target-h，若当前元素比前一个元素小，则将前一个位置赋值到当前位置
                    for (target = i; target - h >= 0 && tmp.compareTo(data[target - h]) < 0; target -= h) {
                        data[target] = data[target - h];
                    }
                    data[target] = tmp;
                }
            }
            h /= 2; //每轮循环间隔缩小一半
        }
    }

    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n);
        SortingHelper.test("ShellSort", arr);

    }
}
