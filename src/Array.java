/*
* 容器
* 容器中的元素数量
* 构造函数（容量）
* * 有参构造
* * 无参构造
* add(), get(), set(), remove() 增查改删
* * addLast(e)
* * add(index, e)
* * addFirst(e)
* * get(index)
* * set(index, e)
* * contains(e)
* * find(e)
* * remove(index)
* * removeFirst()
* * removeLast()
* * removeElement(e)
*
* toString()
* equals()
* compareTo()
* */


public class Array<E> { /* 名称Array 数据类型E */
    private E[] data; //容器
    private int size; //容器中的元素数量，容器的索引范围为 [0,size-1], size 作为索引也可指引第一个没有元素的位置

    //构造函数
    public Array(int capacity) { //容器的容量
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addLast(E e) {
//        if (size == data.length) throw new IllegalArgumentException("Failed to add element to the end of the array.");
//        data[size] = e;
//        size ++;
        add(size, e);
    }

    public void add(int index, E e) {
        if (size == data.length) throw new IllegalArgumentException("Failed to add element to the end of the array.");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(String.format("Failed to add element at index %d (size: %d)", index, size));
        /* 最后一个元素的索引是 size-1 */
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("");
        return data[index];
    }
    public void set(int index, E e) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("");
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("");
        E tmp = data[index];
        for (int i = index; i < size; i++){
            data[i] = data[i+1];
        }
        size --;
        data[size] = null; // loitering object: An object can't be garbage collected as long as it is reachable
        return tmp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) remove(index);
    }

    public void removeAllElement(E e) {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

//public class Array {
//    private int[] data; //容器
//    private int size; //容器中的元素数量，容器的索引范围为 [0,size-1], size 作为索引也可指引第一个没有元素的位置
//
//    //构造函数
//    public Array(int capacity) { //容器的容量
//        data = new int[capacity];
//        size = 0;
//    }
//    public Array() {
//        this(10);
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public int getCapacity() {
//        return data.length;
//    }
//
//    public boolean isEmpty() {
//        return (size == 0);
//    }
//
//    public void addLast(int e) {
////        if (size == data.length) throw new IllegalArgumentException("Failed to add element to the end of the array.");
////        data[size] = e;
////        size ++;
//        add(size, e);
//    }
//
//    public void add(int index, int e) {
//        if (size == data.length) throw new IllegalArgumentException("Failed to add element to the end of the array.");
//        if (index < 0 || index > size) throw new IndexOutOfBoundsException(String.format("Failed to add element at index %d (size: %d)", index, size));
//        /* 最后一个元素的索引是 size-1 */
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }
//        data[index] = e;
//        size ++;
//    }
//
//    public void addFirst(int e) {
//        add(0, e);
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("");
//        return data[index];
//    }
//    public void set(int index, int e) {
//        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("");
//        data[index] = e;
//    }
//
//    public boolean contains(int e) {
//        for (int i = 0; i < size; i++) {
//            if (data[i] == e) return true;
//        }
//        return false;
//    }
//
//    public int find(int e) {
//        for (int i = 0; i < size; i++) {
//            if (data[i] == e) return i;
//        }
//        return -1;
//    }
//
//    public int remove(int index) {
//        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("");
//        int tmp = data[index];
//        for (int i = index; i < size; i++){
//            data[i] = data[i+1];
//        }
//        size --;
//        return tmp;
//    }
//
//    public int removeFirst() {
//        return remove(0);
//    }
//
//    public int removeLast() {
//        return remove(size-1);
//    }
//
//    public void removeElement(int e) {
//        int index = find(e);
//        if (index != -1) remove(index);
//    }
//
//    public void removeAllElement(int e) {
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
//        sb.append('[');
//        for (int i = 0; i < size; i++) {
//            sb.append(data[i]);
//            if (i != size - 1) sb.append(", ");
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//}
