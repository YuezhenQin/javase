package 动态数据结构;/* 操作         队列          循环队列
 * 入队 enqueue O(1) 均摊     O(1) 均摊
 * 出队 dequeue O(n)         O(1) 均摊
 *     peek    O(1)         O(1)
 *     getSize
 *     isEmpty
 * */

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    //入队
    void enqueue(E e);
    //出队
    E dequeue();
    E getFirst();
}
