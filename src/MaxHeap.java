//动态数组实现最大堆
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap() {
        data = new Array<>();
    }
    //返回堆中元素个数
    public int getSize() {
        return data.getSize();
    }
    //返回一个布尔值表示堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }
    //返回一个索引为k的节点的父亲节点的索引
    private int parent(int index) {
        if (index == 0) throw new IllegalArgumentException("index 0 does not have a parent.");
        return (index - 1) / 2;
    }
    //返回索引为k的节点的左孩子
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    //返回索引为k的节点的右孩子
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    private void siftUp(int k) {
        //k==0为根节点或当前节点小于等于其父亲节点终止循环
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    public E findMax() {
        if (data.getSize()==0) throw new IllegalArgumentException("Heap is empty.");
        return data.get(0);
    }

    public void extractMax() {
        E ret = findMax();
        //第一个与最后一个交换，删除最后一个，下沉第一个
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
    }
    //下沉（与孩子节点中的较大一个交换位置）
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {

        }
    }
}
