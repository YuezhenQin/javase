package Trees_and_Graphs;

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

    //Solution100. The same tree
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }

    public static void main(String[] args) {

    }
}
