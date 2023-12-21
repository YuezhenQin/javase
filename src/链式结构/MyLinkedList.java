package 链式结构;

class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size) return -1;
        if (index == 0) return head.val;
        Node curr = head;
        while (index != 0) {
            curr = curr.next;
            index--;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node oldHead = head;
        Node newHead = new Node(val, oldHead);
        head = newHead;
        size ++;
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) throw new IllegalArgumentException("");
        if (head == null) {
            head = new Node(val, null);
            size ++;
        } else {
            if (index == 0) {
                addAtHead(val);
            } else {
                Node prev = head;
                while (index > 1) {
                    prev = prev.next;
                    index--;
                }
                Node curr = new Node(val, prev.next);
                prev.next = curr;
                size ++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("");
        if (index == 0) {
            head = head.next;
            size--;
        }

        Node prev = head;
        while (index > 1) {
            prev = prev.next;
            index --;
        }
        prev.next = prev.next.next;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(1);
        System.out.println(ll);
        ll.addAtIndex(1, 99);
        System.out.println(ll);
        ll.addAtIndex(0,100);
        System.out.println(ll);
        ll.addAtTail(8080);
        System.out.println(ll);
        ll.deleteAtIndex(0);
        System.out.println(ll);
        ll.deleteAtIndex(1);
        System.out.println(ll);
    }
}
