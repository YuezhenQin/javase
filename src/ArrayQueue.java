public class ArrayQueue<E> implements Queue<E> {
    //基于DynamicArray的容器
    private Array<E> arr;

    public ArrayQueue(int capacity) {
        arr = new Array<>(capacity);
    }
    public ArrayQueue() {
        arr = new Array<>();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    public int getCapacity() {
        return arr.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        arr.addLast(e);
    }

    @Override
    public E dequeue() {
        return arr.removeFirst();
    }

    @Override
    public E getFirst() {
        return arr.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("head [");
        for (int i = 0; i < arr.getSize(); i++) {
            sb.append(arr.get(i));
            if (i != arr.getSize() - 1) sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
