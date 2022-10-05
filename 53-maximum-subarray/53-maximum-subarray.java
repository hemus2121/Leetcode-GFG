class Solution {
    public int maxSubArray(int[] nums) {
        // kadanes Algo  - maintain 2 variables 
        int currentSum =0, maxSum = Integer.MIN_VALUE;
        
        for (int i =0;i<nums.length;i++){
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum <=0){
                currentSum =0;
            }
        }
        return maxSum;
    }
}