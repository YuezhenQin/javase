package 链式结构;

/*
* 链表的特性
* 1.链表是最简单的动态数据结构，不存在固定容量的问题。
* 2.理解链表帮助更深入理解引用，甚至是计算机系统中与内存管理有关的机制。
* 3.更深入地理解递归（链表具有天然的递归结构，头结点的next指针指向了一个更短的链表（可以在一个更短的链表中处理一个同样的问题，并将结果链表链接到头结点））
* 4.用于组织更加复杂的数据结构
*
* 单链表(每个节点包含一个指向后一个元素的指针next)
* 双链表(每个节点包含一个指向前一个元素的指针prev和一个指向后一个元素的指针next)
* 循环链表(设立虚拟头结点，尾结点不指向空而指向虚拟头结点)
*
* */

public class LinkedList<E> {
    private class Node {
        public E e; //LinkedList可以直接访问
        public Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //由于牵扯到对LL中间的元素的操作，设立虚拟head 统一对中间元素和对两端元素进行add()和remove()操作的逻辑
    private Node head;
    private int size;

    public LinkedList() {
//        head = null;
        head = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);
        add(0, e);
//        size ++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException("索引越界");
//        if (index == 0) addFirst(e); //addFirst与add逻辑上有差别，设置虚拟head
        else {
            //遍历的目的是找到index位置前一个位置的节点
            Node prev = head; //head是0这个索引位置的元素之前一个的节点
            for (int i = 0; i < index; i++) { //从真正的第一个元素开始遍历，遍历index-1次
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size ++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        //遍历的目的是找到index位置的节点
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = head.next;
        while (current != null) {
            if (current.e.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("LinkedList: size:%d ", size));
        //while循环实现遍历链表
//        Node current = head.next;
//        while (current != null) {
//            sb.append(current + "->");
//        }
//        sb.append("NULL");

//        for循环实现遍历链表
        for (Node current = head.next; current != null; current = current.next) {
            sb.append(current + "->");
        }
        sb.append("NULL");

        return sb.toString();
    }

    //删除单个元素
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("索引越界");
        //遍历的目的是找到index-1位置（index之前一个位置）的节点，才方便去删除它
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        E e = prev.next.e;

        Node n = prev.next;
        prev.next = prev.next.next;
        n.next = null;
        size--;

        return n.e;
    }
    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = head;
        while (prev != null) {
            if (prev.next.e.equals(e)) break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }
    //删除多个元素
    public E removeElements() {
        return null;
    }


    //递归实现
    public void add(E e) {
        head = add(head, e);
    }
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        node.next = add(node.next, e);
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll);
    }
}
