import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        // Store linked list values
        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Compare from both ends
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
