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
    public ListNode deleteMiddle(ListNode head) {
        ListNode start = new ListNode(-1, head);
        ListNode tail = head;
        ListNode mid = start;
        boolean isOdd = true;
        
        while (tail != null) {
            tail = tail.next;
            if (!isOdd) mid = mid.next;
            isOdd = !isOdd;
        }
        mid.next = mid.next.next;
        
        return start.next;
    }
}