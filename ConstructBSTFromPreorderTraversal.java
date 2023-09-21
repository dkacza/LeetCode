public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0], null, null);
        for (int i = 1; i < preorder.length; i++) {
            putNodeIntoTree(preorder[i], root);
        }
        return root;
    }

    private void putNodeIntoTree(int value, TreeNode root) {
        if (value > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(value, null, null);
            } else {
                putNodeIntoTree(value, root.right);
            }
        }
        if (value < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(value, null, null);
            } else {
                putNodeIntoTree(value, root.left);
            }
        }
    }
}
