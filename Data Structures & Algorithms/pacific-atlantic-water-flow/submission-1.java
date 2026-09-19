// class Solution {

//     int[][] direction = {
//         {1, 0},
//         {-1, 0},
//         {0, 1},
//         {0, -1}
//     };

//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
//         List<List<Integer>> res = new ArrayList<>();
//         boolean pacific;
//         boolean atlantic;

//         for(int i = 0; i < heights.length; i++){
//             for(int j = 0; j < heights[0].length; j++){
//                 boolean[][] visitedP = new boolean[heights.length][heights[0].length];
//                 pacific = pacificdfs(i, j, heights, visitedP);
//                 if(pacific){
//                     boolean[][] visitedA = new boolean[heights.length][heights[0].length];
//                     atlantic = atlanticdfs(i, j, heights, visitedA);
//                     if(pacific && atlantic) res.add(List.of(i, j));
//                 }
//             }
//         }

//         return res;
//     }

//     public boolean pacificdfs(int row, int col, int[][] arr, boolean[][] visited){
//         boolean pacific = false;
//         if(row == 0 || col == 0) return true;
//         visited[row][col] = true;

//         for(int[] dir : direction){
//             int newRow = row + dir[0];
//             int newCol = col + dir[1];

//             if(newRow < arr.length && newCol < arr[0].length && newRow >= 0 && newCol >= 0 && !visited[newRow][newCol] && arr[newRow][newCol] <= arr[row][col]){
//                 if(pacificdfs(newRow, newCol, arr, visited)) return true;
//             }
//         }
//         return false;
//     }

//     public boolean atlanticdfs(int row, int col, int[][] arr, boolean[][] visited){
        
//         if(row == arr.length - 1 || col == arr[0].length - 1) return true;
//         visited[row][col] = true;

//         for(int[] dir : direction){
//             int newRow = row + dir[0];
//             int newCol = col + dir[1];
//             // System.out.println(" Row is "+newRow+" Col is "+newCol);
//             if(newRow < arr.length && newCol < arr[0].length && newRow >= 0 && newCol >= 0 && !visited[newRow][newCol] && arr[newRow][newCol] <= arr[row][col]){
//                 if(atlanticdfs(newRow, newCol, arr, visited)) return true;
//             }
//         }
//         return false;
//     }
// }


// Example of Multi Source BFS

class Solution {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int m = heights.length;
        int n = heights[0].length;
        
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];

        // 1. Seed the queues with all border cells
        for (int i = 0; i < m; i++) {
            // Left edge (Pacific)
            pQueue.offer(new int[]{i, 0});
            pVisited[i][0] = true;
            // Right edge (Atlantic)
            aQueue.offer(new int[]{i, n - 1});
            aVisited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            // Top edge (Pacific)
            pQueue.offer(new int[]{0, j});
            pVisited[0][j] = true;
            // Bottom edge (Atlantic)
            aQueue.offer(new int[]{m - 1, j});
            aVisited[m - 1][j] = true;
        }

        // 2. Run Multi-source BFS for both oceans
        bfs(pQueue, pVisited, heights);
        bfs(aQueue, aVisited, heights);

        // 3. Find cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : direction) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check bounds
                if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length) {
                    // Check if unvisited AND if water can flow UPHILL
                    if (!visited[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}