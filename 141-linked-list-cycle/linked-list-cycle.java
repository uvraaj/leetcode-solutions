/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null) { return false; }
        
        ListNode temp = head;
        HashMap<ListNode,Integer> nodeMap = new HashMap<>();

        while (temp != null) {
            if(nodeMap.containsKey(temp)) { return true; }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }
}