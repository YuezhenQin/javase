public class ArrayStack<E> implements Stack<E> {
    Array<E> arr;
    public ArrayStack(int capacity){
        arr = new Array<E>(capacity);
    }
    public ArrayStack() {
        arr = new Array<E>();
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
    public void push(E e) {
        arr.addLast(e);
    }
    public E pop() {
        return arr.removeLast();
    }
    public E peek() {
        return arr.getLast();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack :");
        sb.append("[");
        for(int i = 0; i < arr.getSize(); i++) {
            sb.append(arr.get(i));
            if (i != arr.getSize() - 1) sb.append(", ");
        }
        sb.append("] top");
        return sb.toString();
    }
}
