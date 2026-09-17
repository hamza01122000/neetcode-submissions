class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int row, int col, int[][] grid) {

        if(row < 0 || row >= grid.length ||
           col < 0 || col >= grid[0].length ||
           grid[row][col] == 0) {
            return 0;
        }

        // Mark visited
        grid[row][col] = 0;

        int area = 1;

        area += dfs(row + 1, col, grid);
        area += dfs(row - 1, col, grid);
        area += dfs(row, col + 1, grid);
        area += dfs(row, col - 1, grid);

        return area;
    }
}