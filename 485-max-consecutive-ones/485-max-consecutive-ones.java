class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxCount = Integer.MIN_VALUE, curCount =0;
        for (int num : nums){
            if (num ==1 ){
                curCount++;
            }else if (num==0){
                curCount=0; //reset to ZERO
            }
            maxCount = Math.max(maxCount, curCount);
        }
        return maxCount;
    }
}