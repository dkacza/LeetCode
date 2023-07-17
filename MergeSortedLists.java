class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode previousNode = null;
        if (list1.val < list2.val) {
            previousNode = new ListNode(list1.val);
            list1 = list1.next;
        }
        else {
            previousNode = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode head = previousNode;

        while (true) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    ListNode newNode = new ListNode(list1.val);
                    previousNode.next = newNode;
                    previousNode = newNode;
                    list1 = list1.next;
                } else {
                    ListNode newNode = new ListNode(list2.val);
                    previousNode.next = newNode;
                    previousNode = newNode;
                    list2 = list2.next;
                }
                continue;

            }
            if (list1 != null) {
                ListNode newNode = new ListNode(list1.val);
                previousNode.next = newNode;
                previousNode = newNode;
                list1 = list1.next;
                continue;
            }
            if (list2 != null) {
                ListNode newNode = new ListNode(list2.val);
                previousNode.next = newNode;
                previousNode = newNode;
                list2 = list2.next;
                continue;
            }
            return head;
        }
    }
}
