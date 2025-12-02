/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    /**
     * Main function: Reverses the nodes of a Linked List in groups of size k.
     * This function uses a recursive approach.
     * @param head The starting node of the current list segment.
     * @param k The group size.
     * @return The new head of the processed (potentially reversed) list segment.
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        // Base Case 1: If the list is empty, return null.
        if (head == null) { 
            return null; 
        }

        // Pointer to find the end of the current k-group and the start of the next group.
        ListNode tail = head;
        // Move k steps forward
        for (int i = 0; i < k; i++) {
            // Base Case 2: If 'tail' becomes null before completing k steps, 
            // it means less than k nodes are left. The remaining part should not be reversed.
            if (tail == null) { 
                return head; 
            }
            tail = tail.next;
        }

        // 1. Reverse the current k-group (from 'head' inclusive to 'tail' exclusive).
        // 'newHead' will be the head of the reversed segment.
        ListNode newHead = reverse(head, tail);
        // 

        // 2. The original 'head' is now the tail of the reversed group.
        // Connect its 'next' pointer to the result of the recursive call on the rest of the list.
        head.next = reverseKGroup(tail, k);

        // 3. Return the new head of the fully processed segment.
        return newHead;
    }
    
    /**
     * Helper function: Reverses the segment of the linked list between 'start' and 'end' 
     * using the standard three-pointer iterative approach.
     * @param start The first node of the segment (inclusive).
     * @param end The node marking the end of the segment (exclusive).
     * @return The new head of the reversed segment.
     */
    private ListNode reverse(ListNode start, ListNode end) {

        // 'prev' pointer: Tracks the previously processed node. It will become the new head.
        ListNode prev = null;

        // Loop until 'start' reaches 'end'.
        while (start != end) {
            
            // 1. Store the next node temporarily to avoid losing the rest of the list.
            ListNode next = start.next; 
            
            // 2. Reversal step: Change the current node's 'next' pointer to point to 'prev'.
            start.next = prev;         
            
            // 3. Move 'prev' forward: Current 'start' node becomes the new 'prev'.
            prev = start;              
            
            // 4. Move 'start' forward to the next node (which we saved in 'next').
            start = next;              
        }
        
        // After the loop, 'prev' is the new head of the reversed segment.
        return prev;
    }
}