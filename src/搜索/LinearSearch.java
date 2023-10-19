package 搜索;/*
/*
 * O(1) < O(logn) < O(sqrt(n)) < O(n) < O(nlogn) < O(n^2) <O(2^n) <O(n!)
 */


//1.线性查找(LinearSearch) O(n)
//2.二分查找(BinarySearch) O(logn) 数据已排序是二分查找的前置条件
//3.

public class LinearSearch<E> {
    /*private+static*/
    private LinearSearch() {}

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            /* 每一轮循坏开始，[0, i) no target */
            /* ==, equals(): value or address */
            if (data[i].equals(target)) { /* is i the target? */
                return i;
            }
        }
        /* 所有循环结束, [0,n) no target */
        return -1;

    }
    /* static: Class.method()
    *  non-static: Class obj = new Class(); obj.method()
    */

    public static void main(String[] args) {
//        Integer[] data = {1,2,3,4,5,6,7,8,9,10};

//        int n = 100000;
        int[] sizes = {100_000, 1_000_000, 10_000_000};

        for (int n: sizes) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) LinearSearch.search(data, n); /* the worst case */
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1_000_000_000.0;

            System.out.println("size:" + n + " time:" + time + "s");
        }

//        Person[] people = {new Person("A"), new Person("B"), new Person("C")};
//        System.out.println(LinearSearch.search(people, new Person("a")));
    }
}
