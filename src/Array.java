/*
* 容器
* 容器中的元素数量
* 容量
* 有参构造
* 无参构造
* 增删改查
* * 首
* * 尾
* * 中
*
* */

public class Array {
    private int[] data; //容器
    private int size; //容器中的元素数量

    //构造函数
    /**
     *
     * @param capacity
     */
    public Array(int capacity) { //容器的容量
        data = new int[capacity];
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

    public void addLast(int e) {
        if (size == data.length) throw new IllegalArgumentException("Failed to add element to the end of the array.");
        data[size] = e;
        size ++;
    }
}
