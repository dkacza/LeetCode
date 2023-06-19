import java.util.*;

public class MaxSumLevelOfBT {
        public static Map<Integer, Integer> visited = new LinkedHashMap<>(); // Level, Value;
        public static int maxLevelSum(TreeNode root) {
            // BFS
            visited.clear();
            int currentLevel = 1;
            visited.put(currentLevel, root.val);
            BFS(root, currentLevel);
            System.out.println(visited);

            int result = 1;
            int maxSum = Integer.MIN_VALUE;
            for (int level : visited.keySet()) {
                if (visited.get(level) > maxSum) {
                    maxSum = visited.get(level);
                    result = level;
                }
            }
            return result;
        }
        public static void BFS(TreeNode node, int currentLevel) {
            visited.putIfAbsent(currentLevel + 1, 0);
            if (node == null) return;
            if (node.right == null && node.left == null) return;
            if (node.left != null) {
                int levelSum = visited.get(currentLevel + 1);
                visited.put(++currentLevel, levelSum + node.left.val);
            }
            if (node.right != null) {
                int levelSum = visited.get(++currentLevel);
                visited.put(++currentLevel, levelSum + node.right.val);
            }

            BFS(node.left, currentLevel + 1);
            BFS(node.right, currentLevel + 1);
        }

}
