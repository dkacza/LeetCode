import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MinDifferenceInBST {
    static Set<Integer> visited = new TreeSet<>();
    public static int getMinimumDifference(TreeNode root) {
        visited.clear();
        dfs(root);
        int minDifference = Integer.MAX_VALUE;
        Integer previousItem = null;
        for (int item : visited) {
            if (previousItem == null) {
                previousItem = item;
                continue;
            };
            int difference = Math.abs(item - previousItem);
            if (difference < minDifference) minDifference = difference;
            previousItem = item;
        }
        return minDifference;
    }
    public static void dfs(TreeNode node) {
        // mark as visited
        visited.add(node.val);
        // if no children stop
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            if (!visited.contains(node.left.val)) {
                dfs(node.left);
            }
        }
        if (node.right != null) {
            if (!visited.contains(node.right.val)) {
                dfs(node.right);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, node3, null);
        TreeNode node1 = new TreeNode(1, null, node5);
        int result = getMinimumDifference(node1);
        System.out.println(result);
    }
}
