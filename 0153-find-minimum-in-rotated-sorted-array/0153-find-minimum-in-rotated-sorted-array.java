class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.min(nums[0], nums[1]);
        
        int min = Integer.MAX_VALUE;
        
        int low = 0, high = n-1;
        while (low <= high){
            // if arra is aready sorted in ascending order
            if (nums[low] < nums[high]){
                min = Math.min(nums[low], min);
                break;
            }
            
            int mid = (low + high)/2;
            if (nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid +1;
            }else {
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }
        return min;
        
    }
}