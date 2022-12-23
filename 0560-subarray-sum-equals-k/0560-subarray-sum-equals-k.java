class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // using prefix sum and map kind of stuff 
        int currSum =0, count =0;
        Map<Integer, Integer> prefixCountMap = new HashMap();
        
        for (int i =0;i< nums.length;i++){
            currSum +=nums[i]; //kind of prefix sum
            
            //check if that is required sum
            if (currSum ==k) count++;
            if (prefixCountMap.containsKey(currSum-k)){
                count += prefixCountMap.get(currSum-k);
            }
            //add to map current sum and its count
            prefixCountMap.put(currSum, prefixCountMap.getOrDefault(currSum,0)+1);
        }
        return count;
        
    }
}