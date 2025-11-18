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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n == 0) { return null; }

        return partition(0, n-1, lists);
    }
    private ListNode merge_two_lists(ListNode list1, ListNode list2) {

        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }

        if (list1.val <= list2.val) {
            list1.next = merge_two_lists(list1.next, list2);
            return list1;
        } else {
            list2.next = merge_two_lists(list1, list2.next);
            return list2;
        }
    }
    private ListNode partition(int start, int end, ListNode[] lists) {

        if (start > end) { return null; }
        if ( start == end) { return lists[start]; }

        int mid = start + (end - start) / 2;

        ListNode L1 = partition(start, mid, lists);
        ListNode L2 = partition(mid+1, end, lists);

        return merge_two_lists(L1, L2);
    }
}