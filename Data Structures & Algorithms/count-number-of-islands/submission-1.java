class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        
        return count;
    }

    public void dfs(int row, int col, boolean[][] visited, char[][] grid){
        if(grid[row][col] == '0') return;
        else visited[row][col] = true;
        if(row + 1 < grid.length && !visited[row+1][col]) dfs(row + 1, col, visited, grid);
        if(row - 1 >= 0 && !visited[row-1][col]) dfs(row - 1, col, visited, grid);
        if(col + 1 < grid[0].length && !visited[row][col+1]) dfs(row, col + 1, visited, grid);
        if(col - 1 >= 0 && !visited[row][col-1]) dfs(row, col - 1, visited, grid);
    }
}