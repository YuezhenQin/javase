/* Data Structures, and their operations
 * ** 线性结构(数据元素之间存在一对一关系: 每个元素都有唯一的前驱和后继元素) **
 * array 阵列。阵列的特点是容量在创建时确定，并且之后无法改变。阵列在内部存储中开辟出的空间是连续分布的，所以可以直接寻找索引对应的偏移量，计算出数据的地址。
 * stack 栈是线性结构。栈的操作是阵列的子集。仅一端增减元素，这一端也称为“栈顶”。LIFO
 * queue 队列是线性结构。队列的操作是阵列的子集。一端（队尾）填充元素（入队），另一端（队首）取出元素（出队）。FIFO
 * linked list (LL) 链表是最简单的动态数据结构。链表是离散的，数据存储在E e中，通过各个node中的Node next连接起来的。链表具有天然的递归结构。
 * 动态数据结构包括 linked list (LL) 链表, hash list (HL) 散列表, skip list (SL) 跳表, binary search tree (BST) 二叉搜索树
 * https://blog.csdn.net/qq_21794823/article/details/118638177#:~:text=%E4%BB%80%E4%B9%88%E6%98%AF%E5%8A%A8%E6%80%81%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84,%E8%80%8C%E4%B8%94%E6%95%88%E7%8E%87%E9%83%BD%E5%BE%88%E9%AB%98%E3%80%82
 *
 * ** 树结构、图结构、哈希表、堆 **
 * binary tree 二叉树是动态数据结构。二叉树具有天然的递归结构。
 * 二叉树
 * BST 二叉搜索树是动态数据结构。二叉搜索树是若数据近乎有序，则二叉搜索树退化成链表{1,2,3,4,5}。解决方案是一颗平衡二叉树。
 * 二叉搜索树实现集合 BSTSet
 * Set 集合。集合的特性是不存储重复元素。词汇量统计。
 * Map 映射。映射是维持键值对的数据结构。词频统计。
 *
 * 完全二叉树：深度为h，各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边 (left-hand side)。
 * 满二叉树：深度为k且有2^k-1个结点的二叉树称为满二叉树。满二叉树是一颗特殊的完全二叉树。
 * 平衡二叉树：深度差不超过 1 的树，空树也是平衡二叉树的一种。
 *
 * Heap; binary heap 二叉堆是满足一些特殊性质的二叉树。每一个节点都大于等于它的孩子节点。
 * 最大堆，最小堆（堆是一颗平衡二叉树）
 * 优先队列
 *
 * 线段树（线段树是一颗平衡二叉树，每一个节点存储的是一个线段(区间)，支持查询一个区间[i..j]的最大值最小值数字和）：基于区间的统计查询
 *
 * Trie O(w)
 *
 * AVL
 * 红黑树
 * K-D 树
 * 并查集
 * H 树


 * **图结构**
 * 邻接矩阵
 * 邻接表
 *
 * reference: https://chasserush.github.io/DataStructureVisualizations/
 * */


import java.util.Random;

public class Main {
//    public static boolean isValid(String s) {
//        ArrayStack<Character> stack = new ArrayStack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') stack.push(c);
//            else {
//                if (stack.isEmpty()) return false;
//                char top = stack.pop();
//                if (c == ')' && top != '(' ) return false;
//                if (c == ']' && top != '[' ) return false;
//                if (c == '}' && top != '{' ) return false;
//            }
//        }
//        return stack.isEmpty();
//    }
    public static boolean isValid(String str) {
        ARStack<Character> stack = new ARStack<>();
        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c=='{' ||str.charAt(i)=='[' || str.charAt(i)=='(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char topc = stack.pop();
                if ((c =='}' && topc !='{') || (c ==']' && topc !='[') || (c ==')' && topc !='(')) return false;
            }
        }
        return stack.isEmpty();
    }

    //测试队列运行size个enqueue和dequeue操作所需要的时间。
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

    private static <E> void testStack(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(rand.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000.0;

        System.out.println(stack.getClass() + ": time:" + time + "s size:" + count);
    }




    public static void main(String[] args) {
        /* Array Test */
        ArrayReview nums = new ArrayReview(100);
        nums.add(0, 1);
        System.out.println(nums);

        nums.addLast(10);

        ArrayReviewE<Integer> a = new ArrayReviewE<>(10);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.removeFirst();
        a.removeFirst();
        a.removeLast();
        System.out.println(a);

        ArrayReviewD<Integer> a1 = new ArrayReviewD<>();
        for (int i = 0; i < 10; i++) {
            a1.addLast(i);
        }
        System.out.println(a1);

        a1.add(1, 999);
        System.out.println(a1);

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
        ARStack<Integer> stack = new ARStack<>();
        stack.push(10);
        System.out.println(stack);

        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("(a){}[]"));
        System.out.println(isValid("[]{"));
        System.out.println(isValid("[{}"));

        /* Queue Test */
        ARQueue<Integer> queue = new ARQueue<>();
        //入队3个元素，出队1个元素
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

        LLQueue<Integer> llQueue = new LLQueue<>();
        for (int i = 0; i < 10; i++) {
            llQueue.enqueue(i);
            System.out.println(llQueue);
            if (i % 3 == 2) {
                llQueue.dequeue();
                System.out.println(llQueue);
            }
        }

        /* CircularArrayQueue Test */
        CircularARQueueReview<Integer> cArrayQueue = new CircularARQueueReview<>();
        for(int i = 0; i < 20; i++) {
            cArrayQueue.enqueue(i);
            System.out.println("enqueued:" + cArrayQueue);
            if (i % 3 == 0) {
                cArrayQueue.dequeue();
                System.out.println("dequeued:" + cArrayQueue);
            }
        }


        //AR队列、循环队列、LL队列的性能比较
        int count = 100000;
        ARQueue<Integer> aqueue = new ARQueue<>();
        LLQueue<Integer> llqueue = new LLQueue<>();
        CircularARQueue<Integer> cqueue = new CircularARQueue<>();

        testQueue(aqueue, count); //AR队列
        testQueue(llqueue,count); //LL队列
        testQueue(cqueue, count); //循环AR队列

        //ARStack与LLStack的性能比较
        ARStack<Integer> arrStack = new ARStack<>();
        LLStack<Integer> llStack = new LLStack<>();
        testStack(arrStack, count); //阵列栈
        testStack(llStack, count); //链表栈

        //SegmentTree
        Integer[] r = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(r, (m, n) -> m + n);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));

//        SegmentTree<Integer> tree = new SegmentTree<>(r, new Merger<Integer>() {
//             @Override
//            public Integer merge(Integer a, Integer b) {
//                return a + b;
//            }
//        });

     }
}
