/*        队列          循环队列
* enqueue O(1) 均摊     O(1) 均摊
* dequeue O(n)         O(1) 均摊
* peek    O(1)         O(1)
* */
public class CircularArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int head, tail, size;

    public CircularArrayQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; /* * */
        head = 0;
        tail = 0;
        size = 0;
    }
    public CircularArrayQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        // return tail >= head ? (tail - head) : (tail - head + data.length);
        return size;
    }
    public int getCapacity() {
        return data.length - 1; /* 浪费一个空间 */
    }
    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    @Override
    public void enqueue(E e) {
        /* 是否已满 tail+1 == head */
        if ((tail + 1) % data.length == head) resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        /* 是否为空 */
        if (isEmpty()) throw new RuntimeException("");
        E tmp = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size --;
        if (size < getCapacity() / 4 && getCapacity() / 2 != 0) resize(getCapacity() /2) ;
        return tmp;
    }

    public E peek() {
        if (isEmpty()) throw new RuntimeException("");
        return data[head];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) { /* size << newCapacity */
            newData[i] = data[(head + i) % data.length];
        }
        head = 0;
        tail = size;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size=%d, capacity=%d ", getSize(), getCapacity()));
        sb.append("head [");
        for (int i = head; i != tail; i = (i+1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) sb.append(", "); /* * */
        }
        sb.append("] tail ");
        return sb.toString();
    }














//    private E[] data;
//    private int head, tail; /* 第一个元素的索引; 第一个不存在元素的位置 */
//    private int size;
//
//    public CircularArrayQueue(int capacity) {
//        data = (E[]) new Object [capacity + 1]; /* * */
//        head = 0;
//        tail = 0;
//        size = 0;
//    }
//
//    public CircularArrayQueue() {
//        this(10);
//    }
//
//    @Override
//    public int getSize() {
//        return size;
//    }
//
//    public int getCapacity() {
//        return data.length - 1; /* 有意识地浪费一个空间 */
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return head == tail;
//    }
//
//    @Override
//    public void enqueue(E e) {
//          if ((tail + 1) % data.length == head) resize(getCapacity() * 2);
//          data[tail] = e;
//          tail = (tail + 1) % data.length;
//          size ++;
//    }
//
//    public E dequeue() {
//        if (isEmpty()) throw new IllegalArgumentException("");
//        E tmp = data[head];
//        data[head] = null;
//        head = (head + 1) % data.length;
//        size --;
//        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) resize(getCapacity() / 2);
//        return tmp;
//    }
//
//    public E peek() {
//        if (isEmpty()) throw new RuntimeException("");
//        return data[head];
//    }
//
//    private void resize(int newCapacity) {
//        E[] newData = (E[]) new Object[newCapacity + 1];
//        for (int i = 0; i < size; i++) {
//             newData[i] = data[(head + i) % data.length]; /* * */
//        }
//        data = newData;
//        head = 0;
//        tail = size;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("Queue: size=%d, capacity=%d", size, getCapacity()));
//        sb.append("head [");
//        for (int i = 0; i != tail; i = (i + 1) % data.length) { /* * */
//            sb.append(data[i]);
//            if ((i+1) % data.length != tail) sb.append(", ");
//        }
//        sb.append("] tail");
//        return sb.toString();
//    }
}
