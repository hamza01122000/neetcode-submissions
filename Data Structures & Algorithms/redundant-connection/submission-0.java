class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[edges.length + 1];
        int[] arr = new int[2];

        for(int i = 0; i <= edges.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] dir : edges){
            int first = dir[0];
            int second = dir[1];

            if(!visited[first] || !visited[second]){
                visited[first] = true;
                visited[second] = true;
                graph.get(first).add(second);
                graph.get(second).add(first);
            }
            else{
                visited[first] = true;
                visited[second] = true;
                boolean[] sVisited = new boolean[edges.length + 1];
                sVisited[first] = true;
                if(dfs(first, graph, sVisited, second)){
                    arr[0] = first;
                    arr[1] = second;
                }
                else{
                    graph.get(first).add(second);
                    graph.get(second).add(first);
                }
            }
        }

        return arr;
    }

    public boolean dfs(int index, List<List<Integer>> graph, boolean[] visited, int target){
        List<Integer> list = graph.get(index);

        if(list.isEmpty()) return false;
        else{
            for(int node : graph.get(index)) {

                if(node == target) return true;

                if(visited[node]) {
                    continue;
                }

                visited[node] = true;
                if(dfs(node, graph, visited, target)) return true;
                
            }
        }

        return false;

    }
}