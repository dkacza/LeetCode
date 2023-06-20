<<<<<<< Updated upstream
// Problem 2
// Add Two Numbers

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode result = null;
        ListNode first = new ListNode();
        while (true) {
            int toAdd1 = 0;
            if (l1 != null) {
                toAdd1 = l1.val;
                l1 = l1.next;
            }

            int toAdd2 = 0;
            if (l2 != null) {
                toAdd2 = l2.val;
                l2 = l2.next;
            }

            if (result == null) {
                result = new ListNode(overflow);
                first = result;
            }

            int sum = toAdd1 + toAdd2 + overflow;
            int nodeVal = sum % 10;
            if (sum > 9) overflow = sum / 10;
            else overflow = 0;

            result.val = nodeVal;
            if (l1 == null && l2 == null && overflow == 0) break;
            result.next = new ListNode();
            result = result.next;
        }
        return first;
    }
}
=======
// Problem 2
// Add Two Numbers

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode result = null;
        ListNode first = new ListNode();
        while (true) {
            int toAdd1 = 0;
            if (l1 != null) {
                toAdd1 = l1.val;
                l1 = l1.next;
            }

            int toAdd2 = 0;
            if (l2 != null) {
                toAdd2 = l2.val;
                l2 = l2.next;
            }

            if (result == null) {
                result = new ListNode(overflow);
                first = result;
            }

            int sum = toAdd1 + toAdd2 + overflow;
            int nodeVal = sum % 10;
            if (sum > 9) overflow = sum / 10;
            else overflow = 0;

            result.val = nodeVal;
            if (l1 == null && l2 == null && overflow == 0) break;
            result.next = new ListNode();
            result = result.next;
        }
        return first;
    }
}
>>>>>>> Stashed changes
