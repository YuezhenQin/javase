package 动态数据结构.树结构;

import java.util.*;

/*
* 1.二分搜索树是二叉树
* 2.二分搜索树的节点的值: 大于其左子树的所有节点的值，小于其右子树所有节点的值
* 3.每一棵子树也是二分搜索树
*
* add()
* contains()
* 二叉树的遍历: 前序(根左右)、中序(左根右,二分搜索树中序遍历的结果是顺序排列的)、后序(左右根)、层次、深度优先、广度优先
* * preOrder()
* * inOrder()
* * postOrder()
*
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

    //二叉树的前序遍历（先访问该节点，再访问左右子树）的递归实现
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
//        if (node == null) return;
//        System.out.println(node.e);
//        preOrder(node.left);
//        preOrder(node.right);

        if (node != null) {
            System.out.print(node.e + " "); //先访问该节点
            preOrder(node.left); //再访问左右子树
            preOrder(node.right);
        }
    }

    //二分搜索树前序遍历的非递归实现（模拟系统栈）
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        //压入第一个元素
        stack.push(root);
        while (!stack.isEmpty()) {
            //出栈，压入栈顶元素的右孩子、左孩子（后入先出）。
            Node curr = stack.pop();
            System.out.print(curr.e + " ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
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
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }


    //二叉树的后序遍历 (先处理该节点的所有孩子节点，再处理该节点 )
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二叉搜索树的层序遍历 (队列)
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(curr.e + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
    //寻找二分搜索树中的最小值
    public E findMin() {
        if (size == 0) throw new IllegalArgumentException("BST is empty");
        return findMin(root).e;
    }
    public Node findMin(Node node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }
    //寻找二分搜索树中的最大值
    public E findMax() {
        if (size == 0) throw new IllegalArgumentException("BST is empty");
        return findMax(root).e;
    }
    private Node findMax(Node node) {
        if (node.right == null) return node;
        return findMax(node.right);
    }
    //删除二分搜索树中的最小值
    public E removeMin() {
        E ret = findMin();
        //删除以root为根的二分搜索树中的最小节点，并返回结果二分搜索树的根
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightChild = node.right;
            node.right = null;
            size --;
            return rightChild;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树中的最大值
    public E removeMax() {
        E ret = findMax();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftChild = node.left;
            node.left = null;
            size --;
            return leftChild;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //二分搜索树中删除值为e的节点
    //删除只有左孩子、只有右孩子、左右都有孩子的节点 (Hibbard Deletion)
//    public void remove(E e) {
//        root = remove(root, e);
//    }
//    private Node remove(Node node, E e) {
//        if (node == null) { //不存在
//            return null;
//        }
//        if (e.compareTo(node.e) < 0) { //e < node.e 去左子树中找
//            node.left = remove(node.left, e); //去左子树删除
//            return node;
//        } else if (e.compareTo(node.e) > 0) { //e > node.e 去右子树中找
//            node.right = remove(node.right, e); //去右子树删除
//            return node;
//        } else { //e==node.e
//            //待删除节点左子树为空
//            if (node.left == null) {
//                Node rightChild = node.right;
//                node.right = null;
//                size --;
//                return rightChild;
//            }
//            //待删除节点右子树为空
//            if (node.right == null) {
//                Node leftChild = node.left;
//                node.left = null;
//                size --;
//                return leftChild;
//            }
//            //待删除节点左右都不为空的情况
//            //找到大于待删除节点的最小节点（待删除节点的右子树的最小节点）
//            //用该节点代替待删除节点
//            Node successor = findMin(node.right);
//            successor.right = removeMin(node.right);
//            size ++;
//            successor.left = node.left;
//            node.left = node.right = null;
//            size --;
//            return successor;
//        }
//    }

    //二分搜索树中删除值为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }
    private Node remove(Node node, E e) {
        if (node == null) return null; //没找到e

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            //返回结果树
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightChild = node.right;
                node.right = null;
                size--;
                return rightChild;
            }
            if (node.right == null) {
                Node leftChild = node.left;
                node.left = null;
                size--;
                return leftChild;
            }
            Node precursor = findMax(node.left);
            precursor.left = removeMax(node.left);
            precursor.right = node.right;
            node.left = node.right = null;
            return precursor;
        }
    }


    

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] nums = {5,3,6,8,4,2};
//        for (int num: nums) {
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println("---");
//        bst.preOrderNR();
//        System.out.println("---");
//        bst.inOrder();
//        System.out.println("---");
//        bst.postOrder();
//        System.out.println("---");
//        bst.levelOrder();
        int size = 1000;
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            bst.add(rand.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) < nums.get(i)) System.out.println("not sorted.");
        }
        System.out.println("It has been sorted.");
    }
}

