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
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null || head.next.next == null) { return head; }   //if list is null, contains 1 element or contains 2 elements return head.

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; //will be used to link the odd part to the even part of the list

        while (even != null && even.next != null) {   //loop works until it reaches the last even or odd element
        odd.next = even.next;
        odd = even.next;

        even.next = odd.next;
        even = odd.next;
        }
        odd.next = evenHead;
        
        return head;
    }
}