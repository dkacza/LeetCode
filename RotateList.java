class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        // Determine length
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        k = k % length;
        if (k == 0 || length == 1) return head;

        ListNode firstNode = head;
        node = head;
        int lastNodeIndex = length - k;
        int currentIndex = 1;
        while (currentIndex < lastNodeIndex) {
            node = node.next;
            currentIndex++;
        }
        // Now node points to the last node in new list
        // Get the tail and end the list
        ListNode tail = node.next;
        node.next = null;

        // Link the end of tail with the beginning
        node = tail;
        while (node.next != null) {
            node = node.next;
        }
        node.next = firstNode;

        return tail;
    }
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        new RotateList().rotateRight(node1, 10);
    }
}
