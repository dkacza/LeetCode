import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;

        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (visitedNodes.contains(currentNode)) return true;
            visitedNodes.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }
}
