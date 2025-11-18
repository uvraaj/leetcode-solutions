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
    public ListNode deleteDuplicates(ListNode head) {
        // Base case
        if (head == null || head.next == null) return head;
        
        // Recursive call to process the rest of the list
        head.next = deleteDuplicates(head.next);
        
        // Check if current node is a duplicate of the next one
        return (head.val == head.next.val) ? head.next : head;
    }
}