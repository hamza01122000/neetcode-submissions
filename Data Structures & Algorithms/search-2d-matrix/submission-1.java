class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row_start = 0;
        int row_end = matrix.length - 1;
        int l = Integer.MIN_VALUE;

        while(row_start <= row_end){

            int row_mid = row_start + (row_end - row_start)/2;
            
            if(matrix[row_mid][0] < target){
                
                if(row_mid == matrix.length - 1){
                    l = row_mid;
                    break;
                }
                if(matrix[row_mid + 1][0] > target){
                    l = row_mid;
                    break;
                }
                else{
                    row_start = row_mid + 1;
                }
                
            }
            else if(matrix[row_mid][0] > target){
                
                row_end = row_mid - 1;
                if(row_start > row_end) return false;
            }
            else{
                return true;
            }
        }
        

        int col_start = 0;
        int col_end = matrix[l].length - 1;

        while(col_start <= col_end){
            int col_mid = col_start + (col_end - col_start)/2;
            if(col_start > col_end) return false;
            if(matrix[l][col_mid] < target){
                col_start = col_mid + 1;
            }
            else if(matrix[l][col_mid] > target){
                col_end = col_mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
