package 排序;

import java.util.Arrays;
import java.util.Random;

//动态数组实现最大堆
//最大堆的性质:

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap() {
        data = new Array<>();
    }
    //isHeapify
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(data.getSize()-1); i >= 0; i--)
            siftDown(i);
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
    private int parent(int k) {
        if (k == 0) throw new IllegalArgumentException("index 0 does not have a parent.");
        return (k - 1) / 2;
    }
    //返回索引为k的节点的左孩子
    private int leftChild(int k) {
        return k * 2 + 1;
    }
    //返回索引为k的节点的右孩子
    private int rightChild(int k) {
        return k * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    private void siftUp(int k) {
        //k==0 为根节点或当前节点 <= 其父亲节点，则终止循环
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    public E findMax() {
        if (data.getSize()==0) throw new IllegalArgumentException("Heap is empty.");
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        //第一个与最后一个交换，删除最后一个，下沉第一个
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //下沉：父子节点之间比较，与孩子节点中的较大一个交换位置
    private void siftDown(int k) {
        //若存在左孩子
        while (leftChild(k) < data.getSize()) {
            int left = leftChild(k);
            //若存在右孩子且右孩子大于左孩子, 修改left为right
            if (left + 1 < getSize() && data.get(left + 1).compareTo(data.get(left)) > 0) {
                left ++;
            }
            //若 k 节点大于等于左、右孩子中较大的一个，维持了堆的性质，则提前结束循环，无需交换。
            if (data.get(k).compareTo(data.get(left)) >= 0) {
                break;
            }
            data.swap(k, left);
            k = left;
        }
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 100000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(rand.nextInt(Integer.MAX_VALUE));
        }

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        Integer[] newArr = Arrays.copyOfRange(arr, 0, 10);
        System.out.println(Arrays.toString(newArr));
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("is not sorted.");
            }
        }
        System.out.println("is sorted");
    }



}
