/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // Find the k-th node from groupPrev
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;

                // If fewer than k nodes remain, leave them as-is
                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode groupNext = kth.next;

            // Reverse the sublist of k nodes
            ListNode prev = groupNext; // Connecting tail directly to next group
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the node before this group to the new head (kth)
            ListNode oldGroupHead = groupPrev.next;
            groupPrev.next = kth;

            // Move groupPrev to the end of the newly reversed group
            groupPrev = oldGroupHead;
        }
    }
}