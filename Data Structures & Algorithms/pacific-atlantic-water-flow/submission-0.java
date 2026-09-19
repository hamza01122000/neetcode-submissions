class Solution {

    int[][] direction = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean pacific;
        boolean atlantic;

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                boolean[][] visitedP = new boolean[heights.length][heights[0].length];
                pacific = pacificdfs(i, j, heights, visitedP);
                if(pacific){
                    boolean[][] visitedA = new boolean[heights.length][heights[0].length];
                    atlantic = atlanticdfs(i, j, heights, visitedA);
                    if(pacific && atlantic) res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    public boolean pacificdfs(int row, int col, int[][] arr, boolean[][] visited){
        boolean pacific = false;
        if(row == 0 || col == 0) return true;
        visited[row][col] = true;

        for(int[] dir : direction){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < arr.length && newCol < arr[0].length && newRow >= 0 && newCol >= 0 && !visited[newRow][newCol] && arr[newRow][newCol] <= arr[row][col]){
                if(pacificdfs(newRow, newCol, arr, visited)) return true;
            }
        }
        return false;
    }

    public boolean atlanticdfs(int row, int col, int[][] arr, boolean[][] visited){
        
        if(row == arr.length - 1 || col == arr[0].length - 1) return true;
        visited[row][col] = true;

        for(int[] dir : direction){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // System.out.println(" Row is "+newRow+" Col is "+newCol);
            if(newRow < arr.length && newCol < arr[0].length && newRow >= 0 && newCol >= 0 && !visited[newRow][newCol] && arr[newRow][newCol] <= arr[row][col]){
                if(atlanticdfs(newRow, newCol, arr, visited)) return true;
            }
        }
        return false;
    }
}