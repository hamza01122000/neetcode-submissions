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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummyNode = new ListNode(0);
        ListNode mergeList = dummyNode;

        ListNode curr = head;
        int initialCount = 0;
        int finalCount = 0;

        while(curr != null){
            ListNode temp = curr;
            stack.push(temp);
            initialCount++;
            curr = temp.next;
        }
        ListNode trav = head;

        while(initialCount != finalCount){
            if(finalCount % 2 == 0){
                mergeList.next = trav;
                trav = trav.next;
            }
            else{
                ListNode temp = stack.pop();
                mergeList.next = temp;
            }
            mergeList = mergeList.next;
            finalCount++;
        }

        mergeList.next = null;
    }
}
