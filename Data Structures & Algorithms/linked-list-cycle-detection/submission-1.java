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
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode curr = head;

        if(curr == null || curr.next == null)
            return false;

        while(fastPtr != null){            
            slowPtr = slowPtr.next;
            ListNode temp = fastPtr.next;
            fastPtr = temp != null ? temp.next : null;
            if(slowPtr == fastPtr) return true;
        }

        return false;
    }
}
