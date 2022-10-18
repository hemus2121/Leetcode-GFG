class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];
        Map <Integer, Integer> targetMap = new HashMap();
        
        //iterate input array and check in map
        for (int i =0;i< nums.length;i++){
            if (targetMap.containsKey(target- nums[i])){
                result[0]=i;
                result[1]=targetMap.get(target-nums[i]);
                return result;
                }
                targetMap.put(nums[i], i);
        }
        return result;
    }
}