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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add_recursively(l1, l2, 0);
    }
    private ListNode add_recursively(ListNode l1, ListNode l2, int carry) {
        //Base Case: If both lists are empty and there is no carry left
        if (l1 == null && l2 == null && carry == 0) { return null; }

        // Calculate sum for current position
        int sum = carry;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;

        // Create the new node with the digit (e.g., if sum is 12, node is 2)
        ListNode result = new ListNode(sum % 10);

        // Calculate new carry (e.g., if sum is 12, carry is 1)
        int newcarry = sum / 10;

        // Recursive Step: Build the next connection
        result.next = add_recursively(
            (l1 != null) ? l1.next : null,
            (l2 != null) ? l2.next : null,
            newcarry
        );

        return result;
    }
}