class Solution {
    public int longestConsecutive(int[] nums) {
        
        // using Hashset 
        Set<Integer> numSet = new HashSet();
        for (int num : nums){
            numSet.add(num);
        }
        
        int maxLength = 0;
        
        for (int num : nums){
            // if only if prev is not found so that we start with minimum value
            if (!numSet.contains(num-1)){
                
                int currNum=num;
	            int currentStreak=1;
                
                // check until next numbers are found 
                while (numSet.contains(currNum+1)){
                    currNum++;
                    currentStreak++;
                }
                maxLength = Math.max(maxLength, currentStreak);
            }
        }
        return maxLength;
        
    }
}