package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    public static class TreeNode { //static nested class 是独立类，可以访问 private
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Solution98. valid BST
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean dfs(TreeNode curr, long low, long high) {
        if (curr == null) return true;
        if (low >= curr.val || curr.val >= high) return false;
        boolean left = dfs(curr.left, low, curr.val); //*
        boolean right = dfs(curr.right, curr.val, high); //*
        return left && right;
    }

    //Solution938. range sum of BST
    public static int rangeSum(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        //consider curr
        if (low <= root.val && root.val <= high) sum += root.val;
        //consider left subtree and right subtree
        if (low < root.val) sum += rangeSum(root.left, low, high);
        if (root.val < high) sum += rangeSum(root.right, low, high);
        return sum;
    }

    //Solution530. Minimum Absolute Difference in BST: inorder DFS
    public static int minDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderDFS(root, values);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            min = Math.min(min, values.get(i) - values.get(i - 1));
        }
        return min;
    }
    private static void inOrderDFS(TreeNode curr, List<Integer> values) {
        if (curr == null) return;
        inOrderDFS(curr.left, values);
        values.add(curr.val);
        inOrderDFS(curr.right, values);
    }
}
