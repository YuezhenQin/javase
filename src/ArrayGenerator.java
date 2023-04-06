/* Data Structure    Advantage    Disadvantage (增add删remove改c查s)
* **线性结构**
* array              s, O(1)
* stack
* queue
* linked list
* hash list

* **树结构**
* 二叉树
* 二叉搜索树
* 堆
* B 树
* AVL
* 红黑树
* K-D 树
* 并查集
* H 树
* 线段树

* **图结构**
* 邻接矩阵
* 邻接表
*
* */

import java.util.Random;

/* 2.9 */
public class ArrayGenerator {
    private ArrayGenerator(){}
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = i;
        }
        return arr;
    }
    public static Integer[] generateRandomArray(int n) {
        Integer[] arr = new Integer[n];
        Random rand = new Random();
        for (int i =0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}
