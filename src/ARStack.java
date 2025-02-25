
public class ARStack<E> implements Stack<E> { //动态数组实现的栈
    //栈的属性
    Array<E> arr;
    //栈的构造方法
    public ARStack(int capacity){
        arr = new Array<E>(capacity);
    }
    public ARStack() {
        arr = new Array<E>();
    }


    public int getSize() {
        return arr.getSize();
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
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Stack :");
//        sb.append("[");
//        for(int i = 0; i < arr.getSize(); i++) {
//            sb.append(arr.get(i));
//            if (i != arr.getSize() - 1) sb.append(", ");
//        }
//        sb.append("] top");
//        return sb.toString();
//    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:");
        sb.append('[');
        for (int i = 0; i < getSize(); i++) {
            sb.append(arr.get(i));
            if (i != getSize() - 1) sb.append(", ");
            else sb.append("] top");
        }
        return sb.toString();
    }
}
