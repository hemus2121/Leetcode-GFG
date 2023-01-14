class Solution {
    public int coinChange(int[] A, int B) {
        
        int n = A.length;
        int [][] dp = new int [n][B+1];
        
       // for (int [] row : dp ){
        //    Arrays.fill(row, -1);
        //}
        
        //int ans = computeTopDown(A,n-1,B, dp);
        //return ans == (int)1e9 ? -1: ans;
        
        int ans = computeBottomUp(A, n, B);
        return ans >= (int)1e9 ? -1: ans;
    }
    
    int computeTopDown(int []A, int n, int target, int [][]dp){
        //base case - think as array contains only 1 element 
        if (n==0){
            if (target%A[0] ==0){
                return target/A[0];
            }else return (int)1e9;
        }
        
        if (dp[n][target] != -1)return dp[n][target];
        
        //not pick up coin - reduce count of coins
        int notTaken = computeTopDown(A, n-1, target, dp);
        
        int taken =(int)1e9;
        if ( A[n]<= target){
            // infinite supply of coins --> count of remains same
            taken =  1 + computeTopDown(A,n,target-A[n], dp);
        }
        return dp[n][target] = Math.min(notTaken, taken);
    }
    
    
    int computeBottomUp(int []A, int n, int B){
        int [] [] dp = new int [n][B+1];
        
        //base case - 
        for (int i=0;i<= B;i++){
            if (i%A[0]==0){
                dp[0][i] = i/A[0];
            }else dp[0][i] = (int)(1e9);
        }
        
        for (int i =1;i<n;i++){
            for (int target=0;target<=B;target++){
                
                int notTaken = 0 + dp[i-1][target];
                
                int taken = (int) (1e9);
                if (A[i] <= target){
                    taken = 1+ dp[i][target-A[i]];
                }
                dp[i][target] = Math.min(notTaken,taken);
            }
        }
       return dp[n-1][B];
    }
}