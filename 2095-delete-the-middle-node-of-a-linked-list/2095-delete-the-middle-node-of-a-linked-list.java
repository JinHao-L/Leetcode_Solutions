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
        if (head.next == null) {
            return null;
        }
        ListNode tail = head.next;
        ListNode mid = head;
        boolean isOdd = false;
        boolean firstRun = true;
        
        while (tail != null) {
            tail = tail.next;
            if (!isOdd && !firstRun) mid = mid.next;
            isOdd = !isOdd;
            firstRun = false;
        }
        mid.next = mid.next.next;
        
        return head;
    }
}