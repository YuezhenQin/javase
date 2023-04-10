/*
* enqueue O(1)
* dequeue O(n)
*
* */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E peek();
}
