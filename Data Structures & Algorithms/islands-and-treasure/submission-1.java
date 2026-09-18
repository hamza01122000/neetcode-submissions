// class Solution {
//     public void islandsAndTreasure(int[][] grid) {
       
//        Queue<List<Integer>> q = new LinkedList<>(); 
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        int distance = 1;

//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == 0){
//                     q.offer(List.of(i, j));
//                 }
//             }
//         }

//         while(!q.isEmpty()){
//             int size = q.size();

//             for(int i = 0; i < size; i++){
//                 List<Integer> index = q.poll();
//                 int row = index.get(0);
//                 int col = index.get(1);
//                 visited[row][col] = true;

//                 if(row + 1 < grid.length && !visited[row+1][col] && grid[row+1][col] == 2147483647){
//                     grid[row+1][col] = distance;
//                     q.offer(List.of(row+1, col));
//                     visited[row+1][col] = true;
//                 } 

//                 if(row - 1 >= 0 && !visited[row-1][col] && grid[row-1][col] == 2147483647){
//                     grid[row-1][col] = distance;
//                     q.offer(List.of(row-1, col));
//                     visited[row-1][col] = true;
//                 }   

//                 if(col + 1 < grid[0].length && grid[row][col+1] == 2147483647 && !visited[row][col+1]){
//                     grid[row][col+1] = distance;
//                     q.offer(List.of(row, col+1));
//                     visited[row][col+1] = true;
//                 }   

//                 if(col - 1 >= 0 && !visited[row][col-1] && grid[row][col-1] == 2147483647){
//                     grid[row][col-1] = distance;
//                     q.offer(List.of(row, col-1));
//                     visited[row][col-1] = true;
//                 }   

//             }

//             distance++;
//         }
//     }
// }


class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        // Put all gates into the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    grid[newRow][newCol] == Integer.MAX_VALUE) {

                    grid[newRow][newCol] = grid[row][col] + 1;

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
