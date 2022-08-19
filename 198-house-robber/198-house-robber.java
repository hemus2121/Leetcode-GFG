class Solution {
    
    public int rob (int [] nums){
        int n = nums.length;
        int [] dp = new int [n];
        //if (n==1) return nums[0];
        //int maxValue = Math.max (nums[0], nums[1]);
        //if (n==2) return maxValue;
        Arrays.fill(dp, -1);
        return compute(nums,n, dp, n-1); 
    }
    
    int compute (int [] nums, int n, int [] dp, int start){
        
        //base cases
        if (start == 0) return Math.max(0, nums[0]);
        if (start == 1) return Math.max(nums[0],nums[1]);
        
        if (dp[start] != -1) return dp[start];
        
        int ans =  Math.max(nums[start]+ compute(nums,n, dp,start-2),
                          compute(nums,n, dp,start-1)) ;
        return dp[start] = ans;
    }
    
    /* Iterative approach
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n==1) return nums[0];
        int maxValue = Math.max(nums[0],nums[1]);
        if (n==2) return maxValue;
        
        int [] dp = new int [n];
        dp[0] = nums[0];
        dp[1] = maxValue;
        
        for (int i=2;i< n;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    } */
}