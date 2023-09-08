import java.util.Optional;
import java.util.function.Consumer;

public class EvenGrandparent {
    static int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        BFS(root);
        return sum;
    }
    private final Consumer<TreeNode> addAndCheckGrandchildren = (node) -> {
        Optional<TreeNode> leftGrandChild = Optional.ofNullable(node.left);
        Optional<TreeNode> rightGrandChild = Optional.ofNullable(node.right);

        leftGrandChild.ifPresent((grandChild) -> sum += grandChild.val);
        rightGrandChild.ifPresent((grandChild) ->  sum += grandChild.val);
    };
    private void BFS(TreeNode node) {
        if (node == null) return;
        if (node.val % 2 != 0) {
            BFS(node.left);
            BFS(node.right);
            return;
        }

        // Add left grandchildren
        Optional<TreeNode> leftChild = Optional.ofNullable(node.left);
        leftChild.ifPresent(addAndCheckGrandchildren);

        // Add right grandchildren
        Optional<TreeNode> rightChild = Optional.ofNullable(node.right);
        rightChild.ifPresent(addAndCheckGrandchildren);

        leftChild.ifPresent(this::BFS);
        rightChild.ifPresent(this::BFS);
    }
}
