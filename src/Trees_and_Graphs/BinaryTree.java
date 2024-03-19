package Trees_and_Graphs;

import Hashing.tmp.A;

import java.util.*;

//DFS
//BFS(199.,)
public class BinaryTree {
    public class TreeNode {
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
    //Solution100. is the same tree
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null) return false;
//        boolean leftSubtree = isSameTree(p.left, q.left);
//        boolean rightSubtree = isSameTree(p.right, q.right);
//        return p.val == q.val && leftSubtree && rightSubtree;
//    }


    //Solution104. Maximum depth of binary tree
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //A really important concept regarding recursion is that
    // each function call stores its own variables.
    // Because we are calling the function for each node,
    // that means every node has its own unique values of left and right.

    //Solution112. Path sum
//    public static int targetSum;
//    public static boolean hasPathSum(TreeNode root, int target) {
//        targetSum = target;
//        return dfs(root, 0);
//    }
//
//    private static boolean dfs(TreeNode curr, int sum) { //an integer that represents the current sum of the nodes from the root to the current node
//        if (curr == null) return false; //have an empty tree
//        if (curr.left == null && curr.right == null) { //at a leaf node, check sum against targetSum
//            return sum + curr.val == targetSum;
//        }
//        //if not at a leaf, then either continue down left path or right path, return true if either work.
//        sum += curr.val;
//        boolean left = dfs(curr.left, sum);
//        boolean right = dfs(curr.right, sum);
//        return left || right;
//    }

    //Solution1448. Count nodes in binary trees
    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode curr, int max) {
        if (curr == null) return 0;
        int left = dfs(curr.left, Math.max(curr.val, max));
        int right = dfs(curr.right, Math.max(curr.val, max));

        int ans = left + right;
        if (curr.val >= max) ans += 1;

        return ans;
    }

    //Solution100. the same tree
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }

    //Solution199. the rightmost node at each level of binary tree
    public static List<Integer> rightmostNodes(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if (i == size - 1) ans.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return ans;
    }

    //Solution515. the largest node at each level
    public static List<Integer> largestNodes(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                max = Math.max(curr.val, max);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            ans.add(max);
        }
        return ans;
    }

    //Solution103. zigzag bfs
    public List<List<Integer>> zigzagBFS(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flip = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>(); //*
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
//                levelList.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                if (flip) {
                    levelList.addLast(curr.val);
                } else {
                    levelList.addFirst(curr.val);
                }
            }
            ans.add(levelList);
            flip = !flip;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
