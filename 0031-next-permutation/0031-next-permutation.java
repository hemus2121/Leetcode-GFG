class Solution {
    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length<=1) return ;
        
        //starting from last index to get break point where there is dip
        int i= nums.length-2;
        while (i>=0 && nums[i] >= nums[i+1])
            i--; // reduced index if descending order is present
       
        
        if (i >=0){ // break point is present 
            int j = nums.length-1;
            while (nums[j] <= nums[i]) //get immediate higher elment
                j--;
            swap (nums, i,j);
        }
        //no breakpoint at all - just reverse array elements
        reverse(nums, i+1,nums.length-1);
    }
    
    void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    void reverse(int [] nums, int i, int j){
        while (i< j){
            swap (nums, i++, j--);
        }
    }
}