public class CircularARQueueReview<E> implements Queue<E> {
    E[] data;
    private int head, tail, size;

    public CircularARQueueReview(int capacity) {
        data = (E[]) new Object[capacity + 1]; //容量+1
        head = 0;
        tail = 0;
        size = 0;
    }
    public CircularARQueueReview() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1; //容量-1
    }

    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == head) resize(getCapacity() * 2);

        data[tail] = e;

        tail = (tail + 1) % data.length;

        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("队列为空");
        E e = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) resize(data.length / 2);
        return e;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1]; //新开辟的空间是传入的参数newCapacity+1
        for (int i = 0; i < size; i++) { //循环队列的遍历方式一
            newData[i] = data[(i + head) % data.length]; //newData[0]对应data[head], newData[1]对应data[1+head], newData[i]对应data[i+head]
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public E getFirst() {
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size=%d, capacity=%d", size, getCapacity()));
        sb.append("head [");
        for (int i = head; i != tail; i = (i + 1) % data.length) { //循环队列的遍历方式二
            sb.append(data[i]);
            if ((i+1) % data.length != tail) sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
