class Solution {
    public void setZeroes(int[][] matrix) {
           int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        
        for (int i=0;i< rows;i++){
            //check if value in 1st column is zero set this variable to zero
            if (matrix[i][0]==0) col0=0;
            
            for (int j=1;j<cols;j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0; // set 1st row/column value to 0
                }
            }
        } 
        
        
        for (int i = rows-1;i >=0;i--){
            for (int j = cols-1; j >=1;j--){
                if (matrix[i][0]==0 ||matrix[0][j]==0){ //check if any of row/column value is 0
                    matrix[i][j]=0;
                } 
            }
             if (col0==0) matrix[i][0]=0;
        } 
    }
}