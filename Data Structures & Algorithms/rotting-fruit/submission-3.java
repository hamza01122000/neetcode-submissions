class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int time = -1;
        boolean isAllZero = true;
        int[][] direction = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                    isAllZero = false;
                }
                if(grid[i][j] == 1) isAllZero = false;
            }
        }

        if(isAllZero) return 0;
        if(q.isEmpty()) return -1;

        while(!q.isEmpty()){
            
            int qsize = q.size();
            
            for(int i = 0; i < qsize; i++){
                int[] index = q.poll();
                int row = index[0];
                int col = index[1];
                for(int[] dir : direction){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow < grid.length && newRow >= 0 && newCol < grid[0].length && newCol >= 0 && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
            time++;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return time;
    }
}