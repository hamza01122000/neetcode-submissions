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

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                if(node == null) {
                    list.add(null);
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        for(Integer num : list){
            if(num == null) str.append('/').toString();
            else str.append(num).toString();
            str.append(',');
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] str = data.split(",");
        List<Integer> list = new ArrayList<>();

        for(String st : str){
            if(st.trim().equals("/")) list.add(null);
            else list.add(Integer.valueOf(st.trim()));
        }

        if(list.get(0) == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode();
        root.val = list.get(0);
        queue.add(root);

            while(!queue.isEmpty() && i < list.size()){
                
                TreeNode node = queue.poll();
                Integer left = list.get(2*i + 1);
                Integer right = list.get(2*i + 2);
                i++;

                if(left != null){
                    TreeNode leftTemp = new TreeNode();
                    leftTemp.val = left;
                    node.left = leftTemp;
                    queue.add(leftTemp);
                    
                }
                if(right != null) {
                    TreeNode rightTemp = new TreeNode();
                    rightTemp.val = right;
                    node.right = rightTemp;
                    queue.add(rightTemp);
                }
            }
        
        return root;
    }
}
