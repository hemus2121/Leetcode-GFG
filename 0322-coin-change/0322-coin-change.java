class Solution {
    public int coinChange(int[] A, int B) {
        
        int n = A.length;
        int [][] dp = new int [n][B+1];
        
        for (int [] row : dp ){
            Arrays.fill(row, -1);
        }
        int ans = computeTopDown(A,n-1,B, dp);
        return ans == (int)1e9 ? -1: ans;
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
        
        int taken = (int)Math.pow(10,9);
        if ( A[n]<= target){
            // infinite supply of coins --> count of remains same
            taken =  1 + computeTopDown(A,n,target-A[n], dp);
        }
        return dp[n][target] = Math.min(notTaken, taken);
    }
}