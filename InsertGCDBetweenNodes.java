public class InsertGCDBetweenNodes {

    private int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return null;

        ListNode currentNode = head;
        while(currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            int gcdVal = gcd(currentNode.val, nextNode.val);
            currentNode.next = new ListNode(gcdVal, nextNode);
            currentNode = nextNode;
        }
        return head;
    }
}
