class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            if (n == 1) return null;
            return head;
        }

        ListNode nextNode = head.next;
        int size = 2;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            size++;
        }

        ListNode currentNode = head.next;
        ListNode previousNode = head;
        if (n == size) {
            head = currentNode;
            return head;
        }
        size--;

        while (true) {
            if (n == size) {
                previousNode.next = currentNode.next;
                return head;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            size--;
        }
    }
}
