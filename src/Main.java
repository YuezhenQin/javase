/* Data Structures, and their operations
 * **线性结构**
 * array
 * stack 栈是线性结构。栈的操作是阵列的子集。仅一端增减元素，这一端也称为“栈顶”。LIFO
 * queue 队列是线性结构。队列的操作是阵列的子集。一端（队尾）填充元素（入队），另一端（队首）取出元素（出队）。FIFO
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

    public static void main(String[] args) {
        /* Array Test */
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

        /* Queue Test */
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}

