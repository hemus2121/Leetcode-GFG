class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        
         ArrayList<List<Integer>> resList = new ArrayList<List<Integer>>();
        
        //sort input array
        Arrays.sort(nums);
        
        for (int i =0;i< len-3;i++){
            
            if (i>0 && nums[i]== nums[i-1]) continue;
            
            long target3 = target - nums[i];
            
            for (int j =i+1; j < len-2;j++){
                
                if (j>i+1 && nums[j] == nums[j-1])continue;
                
                long target2 = target3-nums[j];
                int left = j+1;
                int right = len-1;
                
                while ( left < right){
                    long twosum = nums[left] + nums[right];
                    if (twosum < target2){
                        left++;
                    } else if (twosum > target2){
                        right--;
                    } else { 
                        List<Integer> quad = new ArrayList<>(); 
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        resList.add(quad);
                          
                         // Processing the duplicates of number 3
                         while (left < right && nums[left] == nums[left+1]) left++;
                         // Processing the duplicates of number 4
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
                   // Processing the duplicates of number 2
                //while(j + 1 < len && nums[j + 1] == nums[j]) ++j;
            }
            // Processing the duplicates of number 1
            //while (i + 1 < len && nums[i + 1] == nums[i]) ++i;
        }
        return resList;
        
    }
}