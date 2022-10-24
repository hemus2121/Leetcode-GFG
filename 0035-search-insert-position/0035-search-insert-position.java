class Solution {
    public int searchInsert(int[] nums, int target) {
        int low =0, high = nums.length-1;
        while (low <= high){
            int mid = (low +high)/2;
            if (nums[mid]== target) return mid;
            else if (nums[mid] < target) low = low+1;
            else high = high-1;
        }
        return low;
        
    }
}