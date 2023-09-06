public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;


        ListNode tail = new ListNode(head.val, null);
        ListNode currentNode = head.next;
        while (currentNode.next != null) {
            ListNode newTail = new ListNode(currentNode.val, tail);
            tail = newTail;
            currentNode = currentNode.next;
        }
        ListNode newTail = new ListNode(currentNode.val, tail);
        tail = newTail;
        return tail;
    }
    public static void main(String[] args) {

    }
}
