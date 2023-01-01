class Solution {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length-1;
        while (low < high){
            int mid = (low + high)/2;
            
            //checke left boundary
            if (mid ==0)
                return nums[0] >= nums[1]? 0: 1;
            
            if (mid == nums.length-1) // check right boundary
                return nums[nums.length-1] >= nums[nums.length-2] ? nums.length-1 : nums.length-2;
            
            //compare middle one
            if (nums[mid] >= nums[mid-1] && nums[mid] >= nums[mid+1]){
                return mid;
            }
            
            if (nums[mid-1] > nums[mid]){
                high = mid-1;
            }else low = mid+1;
        }
        return low;
    }
}