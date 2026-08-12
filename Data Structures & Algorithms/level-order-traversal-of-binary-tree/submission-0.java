/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<List<Integer>> bfs = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        
        if(root == null) return bfs;
        else {
            list.add(root);
            queue.add(list);
            // bfs.add(list);
        }
        while(!queue.isEmpty()) {
            
            list = bfsTraversal(queue.poll());
            // queue.add(list);
            
            if(!list.isEmpty())
                queue.add(list);
            // System.out.println("Queue is "+queue);
        }
        
        
        return bfs;
    }

    public List<TreeNode> bfsTraversal(List<TreeNode> root){
        List<Integer> valList = new ArrayList<>();
        
        
        List<TreeNode> list = new ArrayList<>();

        // if(root == null) return list;
        
        for(TreeNode node : root){
            valList.add(node.val);
            if(node.left != null) {
                // list.add(root.left.val);
                list.add(node.left);
            }
            if(node.right != null) {
                // list.add(root.right.val);
                list.add(node.right);
            }
            // System.out.println("List Element "+node.val);
        }
        // System.out.println(queue.peekFirst().val);
        // System.out.println(valList);
        // list.add(queue.peekFirst().val);
        // System.out.println(list);
        bfs.add(valList);
        // System.out.println("Final List is "+bfs);
        // queue.poll();
        // System.out.println(queue);
        
        
        return list;
    }
}