package 动态数据结构.树结构;

/*
* 1.二分搜索树是二叉树
* 2.二分搜索树的节点的值: 大于其左子树的所有节点的值，小于其右子树所有节点的值
* 3.每一棵子树也是二分搜索树
* */
public class BST<E extends Comparable<E>> {
    private class Node implements TreePrinter.PrintableNode {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //递归实现 向以 root 为根节点的二分搜索树中 add（）
//    public void add(E e) {
//        if (root == null) { //若根节点为空，则新建一个节点为根节点
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//    }

    //    private void add(Node node, E e) {
//        if (e.compareTo(node.e) == 0) { //add等于当前节点的值的元素
//          return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) { //add小于当前节点的值的元素且左子树为空 (需要额外的判断)
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) { //add大于当前节点的值的元素且右子树为空 (需要额外的判断)
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        //新的递归终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        //返回结果二叉搜索树的根
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二叉树的前序遍历（先访问该节点，再访问左右子树）
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
//        if (node == null) return;
//        System.out.println(node.e);
//        preOrder(node.left);
//        preOrder(node.right);

        if (node != null) {
            System.out.println(node.e); //先访问该节点
            preOrder(node.left); //再访问左右子树
            preOrder(node.right);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBST(root, 0, sb);
        return sb.toString();
    }
    //生成以 node 为根节点，深度为 depth 的二叉树字符串
    private void generateBST(Node node, int depth, StringBuilder sb) {
        //最基本问题的答案
        if (node == null) {
            sb.append(generateDepth(depth) + "NULL\n");
            return;
        }
        sb.append(generateDepth(depth) + node.e + "\n");
        generateBST(node.left, depth + 1, sb);
        generateBST(node.right, depth + 1, sb);
    }

    private String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
    //二叉树的中序遍历

    //二叉树的后序遍历

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num: nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println(bst);
    }
}
