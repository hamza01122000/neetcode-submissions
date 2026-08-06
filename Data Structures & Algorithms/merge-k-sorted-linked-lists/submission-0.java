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
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode dummyNode = new ListNode(0);
        ListNode mergeList = dummyNode;

        for(int i = 0; i < lists.length; i++){
            ListNode curr = lists[i];
            while(curr != null){
                arr.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(arr);

        for(int i = 0; i < arr.size(); i++){
            ListNode temp = new ListNode(arr.get(i));
            mergeList.next = temp;
            mergeList = mergeList.next;
        }
        // System.out.println(arr);

        return dummyNode.next;
    }
}
