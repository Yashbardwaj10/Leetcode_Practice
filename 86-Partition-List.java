class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessHead = new ListNode(0);
        ListNode greaterEqualHead = new ListNode(0);
        ListNode lessPtr = lessHead;
        ListNode greaterEqualPtr = greaterEqualHead;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                lessPtr.next = current;
                lessPtr = lessPtr.next;
            } else {
                greaterEqualPtr.next = current;
                greaterEqualPtr = greaterEqualPtr.next;
            }
            current = current.next;
        }

        greaterEqualPtr.next = null; // Important: terminate the greaterEqual list
        lessPtr.next = greaterEqualHead.next; // Connect the two lists

        return lessHead.next;
    }
}