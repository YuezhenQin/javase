package 动态数据结构;


//iterGet()
//recGet()

public class LinkedListReview<E> {
    private class Node {
        E e;
        Node next;
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

    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void add(E e) {
        head = recAdd(head, e);
        size ++;
    }

    public Node recAdd(Node current, E e) {
        if (current == null) return new Node(e);
        current.next = recAdd(current.next, e);
        return current;
    }
}
