class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] dir : edges){
            graph.get(dir[0]).add(dir[1]);
            graph.get(dir[1]).add(dir[0]);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int index, List<List<Integer>> graph, boolean[] visited){

        List<Integer> list = graph.get(index);

        if(list.isEmpty()) return;

        for(int node : list){
            if(!visited[node]){
                visited[node] = true;
                dfs(node, graph, visited);
            }
        }
    }
}
