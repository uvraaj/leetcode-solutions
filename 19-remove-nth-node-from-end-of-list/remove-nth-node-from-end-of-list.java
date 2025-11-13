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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) { return head; }

        //step1: calculating the length of
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        //step2: deleting the required node
        if (length == n) { return head.next; }
        int required = length - n;
        temp = head;
        while (temp != null) {
            required--;
            if (required == 0) { break; }
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}