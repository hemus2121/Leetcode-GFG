class Solution {
    public void moveZeroes(int[] nums) {
        
        //get the index of the 1st zero
        int n = nums.length;
        int index;
        for (index =0;index< n;index++){
            if (nums[index]==0) {
                break;
            }
        }
        
        int i = index;
        int j = index+1;
        while ( i < n  && j < n){
            // swap if j points to non zero element
            if (nums[j] !=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        
    }
}