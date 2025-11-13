class Solution {
    int count = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        // Recursive call to reach the end
        head.next = removeNthFromEnd(head.next, n);

        // Backtracking: increment count
        count++;
        if (count == n) {
            return head.next; // Delete this node
        }
        
        return head;
    }
}