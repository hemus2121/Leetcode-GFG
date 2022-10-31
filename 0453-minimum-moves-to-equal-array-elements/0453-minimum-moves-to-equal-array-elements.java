class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        //get the minimum element
        for (int num : nums){
            min = Math.min(min, num);
        }
        
        // Get the minimum difference from all elements to min element
        int diffCount =0;
        for (int num : nums){
            diffCount += num-min;
        }
        return diffCount;
        
    }
}