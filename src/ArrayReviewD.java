//泛型特性
public class ArrayReviewD<E> {
    private E[] data;
    private int size;

    public ArrayReviewD(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public ArrayReviewD() {this(10);}

    public int getSize() {
        return size;
    }

    public int getCapacity() {
         return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //根据newCapacity进行伸缩
    private void resize (int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("索引越界");
        if (size == data.length) resize(2 * size); //扩容量与当前量相关

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
        data[index] = e;
    }


    public boolean contains(E e) {
        if (size == 0) return false;

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true; //类对象之间进行值的比较，使用equals()
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    public int[] findAll(E e) {
        return new int[]{};
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");

        //存放索引为index的被删除的元素
        E e = data[index];

        //从索引位置+1(右侧)的元素到最后一个元素，向左(-)移动一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; //loitering objects

        if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2); //data.length != 1
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public void removeElement(E e) {
        //如果存在，就删除一个
        int index = find(e);
        if (index != -1) remove(index);
    }

    public void removeAllElement(E e) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) { //如果不是最后一个元素，就...
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
