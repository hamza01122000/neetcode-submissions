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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode newList = dummyNode;
        newList.next = null;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int haasil = 0;
        
        while(curr1 != null || curr2 != null || haasil != 0){
            int sum = 0;
            if(curr1 != null){
                sum = curr1.val + sum;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                sum = curr2.val + sum;
                curr2 = curr2.next;
            }
            
            sum = sum + haasil;
                haasil = sum / 10;

            ListNode temp = new ListNode(sum % 10);
            newList.next = temp;
            newList = newList.next;
            
        }

        return dummyNode.next;
    }
}
