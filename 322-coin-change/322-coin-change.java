class Solution {
    public int coinChange(int[] A, int B) {
        int n = A.length;
        int[][] dp=new int[n+1][B+1];

        // this is initalized to 1 since ZERO j it means thats we already got 1 way to get change which is zero
         for(int i=1;i<=B;i++){
            dp[0][i]=B+1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=B;j++){
                 dp[i][j]=dp[i-1][j];
                if(j>=A[i-1]){
                    dp[i][j]=Math.min( dp[i][j], dp[i][j-A[i-1]]+1);
                }
            }
        }
        //System.out.println("Value:" + dp[n][B] + " B:"+B);
        return dp[n][B] >B ? -1: dp[n][B];
    }
}