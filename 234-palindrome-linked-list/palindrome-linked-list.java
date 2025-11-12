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
    public boolean isPalindrome(ListNode head) {

        //If list is empty it is palindrome by defination
        if (head == null || head.next == null) { return true; }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse_linked_list(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) { return false; }

            first = first.next;
            second = second.next;
        }
        return true;
    }
    private ListNode reverse_linked_list(ListNode head) {

        if (head == null || head.next == null) { return head; }

        ListNode newHead = reverse_linked_list(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}