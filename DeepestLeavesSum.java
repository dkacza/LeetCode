import java.util.HashSet;
import java.util.Set;

public class DeepestLeavesSum {
    private static int maxDepth;
    private static int sum;


    public int deepestLeavesSum(TreeNode root) {
        maxDepth = Integer.MIN_VALUE;
        sum = 0;
        findMaxDepth(root, 1);
        getSumAtDepth(root, 1);
        return sum;
    }

    private void getSumAtDepth(TreeNode node, int currentDepth) {
        if (currentDepth == maxDepth) sum += node.val;
        if (node.left != null) getSumAtDepth(node.left, currentDepth + 1);
        if (node.right != null) getSumAtDepth(node.right, currentDepth + 1);
    }

    private void findMaxDepth(TreeNode node, int currentDepth) {
        if (node.left == null && node.right == null) {
            if (currentDepth > maxDepth) maxDepth = currentDepth;
        }
        if (node.left != null) findMaxDepth(node.left, currentDepth + 1);
        if (node.right != null) findMaxDepth(node.right, currentDepth + 1);
    }
}

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
