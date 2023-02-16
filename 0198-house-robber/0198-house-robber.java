class Solution {
    
    public int rob (int [] nums){
        int n = nums.length;
        int [] dp = new int [n];
        //if (n==1) return nums[0];
        //int maxValue = Math.max (nums[0], nums[1]);
        //if (n==2) return maxValue;
        Arrays.fill(dp, -1);
        //return compute(nums,n, dp, n-1); 
        return computeIter(n, nums, dp);
    }
    
   /* int compute (int [] nums, int n, int [] dp, int start){
        
        //base cases
        if (start == 0) return Math.max(0, nums[0]);
        if (start == 1) return Math.max(nums[0],nums[1]);
        
        if (dp[start] != -1) return dp[start];
        
        int ans =  Math.max(nums[start]+ compute(nums,n, dp,start-2),
                          compute(nums,n, dp,start-1)) ;
        return dp[start] = ans;
    } */
    
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