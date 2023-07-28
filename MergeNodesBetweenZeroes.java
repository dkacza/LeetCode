public class MergeNodesBetweenZeroes {
    public ListNode mergeNodes(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        int cycleSum = 0;
        ListNode cycleStartNode = head;
        boolean firstIter = true;
        while (node.next != null) {
            if (firstIter) {
                node = node.next;
                firstIter = false;
                continue;
            }

            if (node.val == 0) {
                cycleStartNode.val = cycleSum;
                cycleSum = 0;
                cycleStartNode.next = node;

                cycleStartNode = node;
                node = node.next;
                continue;
            }
            cycleSum += node.val;
            node = node.next;
        }
        cycleStartNode.val = cycleSum;
        cycleStartNode.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] values = new int[]{0, 3, 1, 0, 4, 5, 2, 0};
        ListNode list = new ListNode(values);
        MergeNodesBetweenZeroes solution = new MergeNodesBetweenZeroes();
        solution.mergeNodes(list);
    }
}
