import java.util.Arrays;

public class MaxBST {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;

        // Find max value
        int maxIndex = 0;
        int max = nums[maxIndex];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[maxIndex];
            }
        }
        // Create node
        TreeNode root = new TreeNode(max, null, null);
        // Build left half recursively
        int[] leftSub = Arrays.copyOfRange(nums, 0, maxIndex);
        root.left = constructMaximumBinaryTree(leftSub);

        // Build right half recursively
        int[] rightSub = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        root.right = constructMaximumBinaryTree(rightSub);

        return root;
    }
}
