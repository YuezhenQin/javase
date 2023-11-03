package 链式结构.树结构;

import 链式结构.Map;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            Node left = null;
            Node right = null;
        }
    }
    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void add(K key, V value) {
        root = add(key, value, root);
    }

    private Node add(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(key, value, node.left);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(key, value, node.right);
        } else {
            node.value = value;
        }
        return node;
    }

    //返回以Node为root的二分搜索树中key所在的节点
    private Node getNode(Node node, K key) {
        if(node == null) return null;

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node==null? null: node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) throw new IllegalArgumentException(key + " doesn't exist.");
        node.value = newValue;
    }

    //简洁写法
    public Node findMinNode(Node node) {
        if (node.left == null) return node;
        return findMinNode(node.left);
    }

    public Node removeMinNode(Node node) {
        if (node.left == null) {
            Node rightTree = node.right;
            node.right = null;
            size--;
            return rightTree;
        }
        node.left = removeMinNode(node.left);
        return node;
    }

    //从二叉搜索树中删除 key
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightTree = node.right;
                node.right = null;
                size --;
                return rightTree;
            }
            if (node.right == null) {
                Node leftTree = node.left;
                node.left = null;
                size --;
                return leftTree;
            }
            //待删除节点左、右都不为空
            Node successor = findMinNode(node.right);
            successor.right = removeMinNode(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
}
