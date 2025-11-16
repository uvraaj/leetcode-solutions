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
    private ListNode find_middle(ListNode head) {

        if (head == null || head.next == null) { return head; }

        ListNode slow = head; 
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge_sorted_lists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) { temp.next = list1; }
        else { temp.next = list2; }

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
/*
 this problem can be solved into 3 parts (using merge sort algorithm):
 1. finding the middle node 
 2. slpiting the list into two halves and sorting them 
 3. merging the sorted halves.
 */
    if (head == null || head.next == null) { return head; }

    ListNode middle = find_middle(head);

    ListNode right = middle.next;
    middle.next = null;
    ListNode left = head;

    //recursivly sorting the two halves
    left = sortList(left);
    right = sortList(right);

    return merge_sorted_lists(left, right); 
    }
}