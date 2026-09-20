class Solution {

    int[][] direction = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O'){
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] index = q.poll();
            int row = index[0];
            int col = index[1];

            for(int[] dir : direction){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < board.length && newRow >= 0 && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == 'O' && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!visited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}