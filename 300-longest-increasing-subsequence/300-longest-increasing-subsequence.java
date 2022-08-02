class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        int maxCount=-1;
        //lets iterate input array elements
        for (int i=0;i<n;i++){    
             for (int j =0;j<i;j++){
                 //check for strict smaller elements
                 if (nums[j] < nums[i]){ 
                     dp[i] = Math.max(dp[i], dp[j]);
                 }
             }
             dp[i]++; //add +1 for previous value to account for current element 
             maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }
}