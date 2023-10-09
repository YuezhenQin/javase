/* Data Structures, and their operations
 * **线性结构**
 * array 阵列。阵列的元素是连续分布的。最好用于索引有意义的情况。
 * stack 栈是线性结构。栈的操作是阵列的子集。仅一端增减元素，这一端也称为“栈顶”。LIFO
 * queue 队列是线性结构。队列的操作是阵列的子集。一端（队尾）填充元素（入队），另一端（队首）取出元素（出队）。FIFO
 * * 栈与队列的应用
 *     用动态数组实现栈和队列
 *     用栈实现队列
 *     用队列实现栈
 *     最小栈
 * linked list 链表。链表是离散的元素 连接起来的。
 *  数据存储在node中。
 *
 *  更深入地理解引用
 *  更深入地理解递归
 *  辅助组成其它数据结构

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

public class Main {
    public static boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(' ) return false;
                if (c == ']' && top != '[' ) return false;
                if (c == '}' && top != '{' ) return false;
            }
        }
        return stack.isEmpty();
    }

    //使用queue，运行size个enqueue和dequeue操作所需要的时间。
    private static void testQueue(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(rand.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println(queue.getClass() + ": time:" + time + "s size:" + count);
    }

    public static void main(String[] args) {
        /* Array Test */
        ArrayReview nums = new ArrayReview(100);
        nums.add(0, 1);
        System.out.println(nums);



        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(10, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(1);
        arr.remove(1);
        System.out.println(arr);

        /* Stack Test */

        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(10);
        System.out.println(stack);

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        System.out.println(isValid("(){}[]"));

        /* ArrayQueue Test */
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

        /* CircularArrayQueue Test */
        CircularArrayQueue<Integer> cArrayQueue = new CircularArrayQueue<>();
        for(int i = 0; i < 10; i++) {
            cArrayQueue.enqueue(i);
            System.out.println("enqueued:" + cArrayQueue);
            if (i % 3 == 0) {
                cArrayQueue.dequeue();
                System.out.println("dequeued:" + cArrayQueue);
            }
        }

        int count = 100000;
        ArrayQueue<Integer> aqueue = new ArrayQueue<>();
        CircularArrayQueue<Integer> cqueue = new CircularArrayQueue<>();
        testQueue(aqueue, count);
        testQueue(cqueue, count);

     }
}

