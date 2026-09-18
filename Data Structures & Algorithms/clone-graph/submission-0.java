/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // Create clone of starting node
        map.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()) {

            Node current = q.poll();

            // Get the clone of current node
            Node clonedCurrent = map.get(current);

            for (Node neighbor : current.neighbors) {

                // If neighbor hasn't been cloned yet
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                // Connect cloned current → cloned neighbor
                clonedCurrent.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}