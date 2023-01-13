class Solution {
    public boolean canPartition(int[] nums) {
        
        // get the total
        int sum =0;
        for (int num: nums){
            sum += num;
        }
        
        if (sum%2!=0) return false;    
        int target = sum/2;
    
        boolean [] prev = new boolean[target+1];
        
        for (int i =1;i< nums.length;i++){
            prev[0]=true;
            boolean [] curr = new boolean [target+1];
            for (int j = 1; j <=target;j++){
                
                boolean notpick = prev[j];
                boolean pick = false;
                if (nums[i] <= j){
                    pick =  prev[j-nums[i]];
                } 
                curr[j] = (notpick || pick);
            }
            prev = curr;
        }
        return prev[target];
    }
}