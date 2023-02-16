class Solution {
    
    public int rob (int [] nums){
        int n = nums.length;
        int [] dp = new int [n];
        //if (n==1) return nums[0];
        //int maxValue = Math.max (nums[0], nums[1]);
        //if (n==2) return maxValue;
        Arrays.fill(dp, -1);
        return compute(n-1, nums, dp); 
        //return computeIter(n, nums, dp);
    }
    
    
    int compute (int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ compute(ind-2, arr,dp);
        int nonPick = 0 + compute(ind-1, arr, dp);
    
        return dp[ind]=Math.max(pick, nonPick);
    } 
    
    //Iterative approach
    public int computeIter(int n, int[] nums, int [] dp) {
        dp[0]= nums[0];
    
        for(int i=1 ;i<n; i++){
          int pick = nums[i];
          if(i>1)
            pick += dp[i-2];
            int nonPick = 0 + dp[i-1];
        
        dp[i]= Math.max(pick, nonPick);
        }
         return dp[n-1];
    } 
}