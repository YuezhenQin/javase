/*
* 容器data
* 容器中的元素数量size
* 构造函数（容量）capacity
* * addLast(e)        均摊复杂度 O(1)
* * add(index, e)     O(n)
* * addFirst(e)       O(n)

* * remove(index)     O(n)
* * removeFirst()     O(n)
* * removeLast()      均摊复杂度 O(1)
* * removeElement(e)  O(n)

* * get(index)        O(1) 已知索引
* * getLast()
* * getFirst()
* * contains(e)       O(n) 未知索引
* * find(e)           O(n) 未知索引

* * set(index, e)     O(1), “随机访问”

* toString()
* equals()
* compareTo()

* resize() 伸缩        O(n)
* */


/*
* 局限1.固定的数据类型->泛型 1.7
* 局限2.固定的容量->动态地伸缩容量 1.8
* 局限3.addLast(),removeLast() 复杂度震荡->Lazy Resize 1.10
* */

public class Array<E> {
    /*Array的变量*/
    private E[] data; //容器
    private int size; //容器中的元素数量，容器的索引范围为 [0,size-1], size 作为索引也可指引第一个没有元素的位置（下一个待加入元素的位置）

    /*Array的构造函数*/
    public Array(int capacity) { //容器的容量
        data = (E[]) new Object[capacity]; /* E[capacity]*/
        size = 0;
    }
    public Array() {
        this(10);
    }

    /*Array的增、删、改、查方法*/
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
        /* 索引是否越界 */
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(String.format("Failed to add element at index %d (size: %d)", index, size));
        /* 容器是否已满，size指引第一个没有元素的位置 */
//        if (size == data.length) throw new IllegalArgumentException("Failed to add element to the end of the array.");
        if (size == data.length) {
            resize(2 * data.length);
        }
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

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
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
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null; // loitering object: An object can't be garbage collected as long as it is reachable
        /* 防止复杂度震荡 */
        if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
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
        sb.append(String.format("Array: size = %d, capacity = %d ", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]); //将对象作为字符串处理时调用对象所属于的类中的toString()
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) { /* i < size 而不是 i < data.length */
            newData[i] = data[i];
        }
        data = newData;
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
