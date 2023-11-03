package 链式结构;

//基于链表实现的映射
public class LLMap<K, V> implements Map<K, V>{
    //节点
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key) {
            this(key, null, null);
        }
        public Node() {
            this(null, null, null);
        }
        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LLMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node result = getNode(key);
        return result == null? null: result.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new RuntimeException(key + " doesn't exist.");
        } else {
            node.value = newValue;
        }
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        } else {
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    public static void main(String[] args) {
        LLMap<String, Integer> llMap = new LLMap<>();
        llMap.add("a", 1);
        llMap.add("b", 2);
        System.out.println(llMap.isEmpty());
        System.out.println(llMap.get("b"));
        llMap.remove("b");
        System.out.println(llMap.get("b"));
        llMap.set("a",99);
        System.out.println(llMap.get("a"));
        llMap.remove("a");
        System.out.println(llMap.isEmpty());
    }
}
