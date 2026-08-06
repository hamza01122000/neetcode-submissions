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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        ListNode newList = dummyNode;
        newList.next = head;
        int listSize = 0;
        ListNode curr = head;

        while(curr != null){
            listSize++;
            curr = curr.next;
        }

        int removeNode = listSize - n;
        int visitedNode = 0;

        while(newList != null){
            if(visitedNode == removeNode){
               newList.next = newList.next.next;
               break;
            }
            else{
                newList = newList.next;
            }
            
          visitedNode++;
        }

        return dummyNode.next;
    }
}
