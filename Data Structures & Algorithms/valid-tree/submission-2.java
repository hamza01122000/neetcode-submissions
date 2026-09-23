class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] dir : edges){
            graph.get(dir[0]).add(dir[1]);
            graph.get(dir[1]).add(dir[0]);
        }

        // System.out.println(graph.size());
        // System.out.println(graph);

        // for(int i = 0; i < graph.size(); i++){
        visited[0] = true;
        if(dfs(0, 0, visited, graph)) {
            // System.out.println("Result is returning from here");
            return false;
        }
        // }

        for(int i = 0; i < n; i++){
            // System.out.println("visited Array ");
            if(!visited[i]) return false;
        }

        return true;
    }

    public boolean dfs(int index, int parent, boolean[] visited, List<List<Integer>> graph){
        // System.out.println(index);
        // System.out.println("Parent is "+parent);
        List<Integer> list = graph.get(index);
        // System.out.println("List of particluar Index is "+list);

        if(list.isEmpty()) return false;
        else{
            for(int node : graph.get(index)) {

                // Ignore the edge through which we came
                if(node == parent) {
                    continue;
                }

                // Visited node other than parent = cycle
                if(visited[node]) {
                    return true;
                }

                visited[node] = true;

                if(dfs(node, index, visited, graph)) {
                    return true;
                }
            }
        }

        return false;

    }
}
