public class LLQueue<E> implements Queue<E> {
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


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        //队列为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            Node newNode = new Node(e, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (tail == null) throw new IllegalArgumentException("队列为空");
        Node retNode = head;
        head = head.next;
        retNode.next =  null;
        //最后一个元素
        if (head == null) tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFirst() {
        if (tail == null) throw new IllegalArgumentException("队列为空");

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LLQueue: head ");
        //LL作为底层实现的遍历方式
        for (Node current = head; current != null; current = current.next) {
            sb.append(current).append("->");
        }
        sb.append("NULL tail");
        return sb.toString();
    }

    
}
