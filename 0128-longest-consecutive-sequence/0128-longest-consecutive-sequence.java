class Solution {
    public int longestConsecutive(int[] nums) {
        
        // using Hashset 
        Set<Integer> numSet = new HashSet();
        for (int num : nums){
            numSet.add(num);
        }
        
        int maxLength = 0;
        
        for (int i=0;i< nums.length;i++){
            int prev = nums[i]-1;
            int count =1;
            // if and only if prev is not found so that we start withminimum value
            if (!numSet.contains(prev)){
                int next = nums[i]+1;
                // check until next numbers are found 
                while (numSet.contains(next)){
                    next++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
        
    }
}