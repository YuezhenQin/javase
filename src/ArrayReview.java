public class ArrayReview {
    private int[] data;
    private int size;

    public ArrayReview(int capacity) {
        data = new int[capacity];
        size = 0; //索引容器中第一个没被占用的位置
    }
    public ArrayReview() {
        this(10); //this() 无参调用有参构造函数
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
         return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(int e) {
        if (size == data.length) throw new IllegalArgumentException("容器已满");
        data[size] = e;
        size ++;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void add(int index, int e) {
        //1.索引是否合法
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("索引越界");
        //2.容器有足够的空间容纳该元素
        if (size == data.length) throw new IllegalArgumentException("容器已满");

        //从最后一个元素到索引位置元素，向右(+)移一位
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    public int get(int index) {
        //1.索引是否合法
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
        return data[index];
    }

    public void set(int index, int e) {
        //1.索引是否合法
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");
        data[index] = e;
    }


    public boolean contains(int e) {
        if (size == 0) return false;

        for (int i = 0; i < size; i++) {
            if (e == data[i]) return true;
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return i;
        }
        return -1;
    }

    public int[] findAll(int e) {
        return new int[]{};
    }

    public int remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("索引越界");

        //存放索引为index的被删除的元素
        int e = data[index];

        //从索引位置+1(右侧)的元素到最后一个元素，向左(-)移动一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        return e;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size-1);
    }

    public void removeElement(int e) {
        //如果存在，就删除一个
        int index = find(e);
        if (index != -1) remove(index);
    }
    public void removeAllElement(int e) {

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
