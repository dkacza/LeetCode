class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class MinimumDepthOfBT {
    private static int min;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        min = Integer.MAX_VALUE;
        BFS(root, 1);
        return min;
    }
    private void BFS(TreeNode node, int currentDepth) {
        if (node.left == null && node.right == null) {
            if (currentDepth < min) min = currentDepth;
        }
        if (currentDepth > min) return;
        if (node.left != null) BFS(node.left, currentDepth + 1);
        if (node.right != null) BFS(node.right, currentDepth + 1);
    }
}
