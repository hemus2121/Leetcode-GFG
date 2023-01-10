class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [] [] dp = new int [m][n];
        for (int [] row : dp){
            Arrays.fill(row, -1);
        }
        //return computeTopDown(obstacleGrid, m-1, n-1, dp);
        return computeBottomUp(obstacleGrid, m, n, dp);
    }
    
    int computeTopDown(int[][]  obstacleGrid, int row, int col, int [][] dp){
        
        //base case
        if (row >=0 && col>=0 && obstacleGrid[row][col]==1) return 0;
        if (row==0 && col ==0) return 1;
        if (row <0 || col <0) return 0;
       
        
        if (dp[row][col] != -1) return dp[row][col];
        
        int up = computeTopDown(obstacleGrid, row-1, col, dp);
        int left = computeTopDown(obstacleGrid, row, col-1, dp);
        return dp[row][col] = up +left;
    }
    
    int computeBottomUp(int[][]  obstacleGrid, int row, int col, int [][] dp ){
        
        if (obstacleGrid [0][0]==1) return 0;
        
        for (int i =0;i< row;i++){
            for (int j =0;j<col;j++){
                
                if (i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                if (i >=0 && j>=0 && obstacleGrid[i][j]==1){
                    dp[i][j]=0; 
                    continue;
                }
                
                int up=0, down=0;
                if (i >0) up = dp[i-1][j];
                if (j >0) down = dp[i][j-1];
                
                dp[i][j] = up + down;
            }
        }
        return dp [row-1][col-1];
    }
}