class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        int firstoccurance = getFirst(nums, target);
         if (firstoccurance == -1) {
             return new int []{ -1, -1};
         }
        int lastoccurance = getLast(nums, target);
        return new int [] { firstoccurance, lastoccurance};
    }
    
    int getFirst (int [] nums, int target){
        int low =0, high = nums.length-1;
        int res=-1;
        while (low <= high){
            int mid = (low +high)/2;
            if (nums[mid]== target){
                res = mid;// probable 
                high = mid-1;
            }else if (target < nums[mid]){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return res;
    }
    
    int getLast (int []nums, int target){
        int low =0, high = nums.length-1;
        int res=-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (nums[mid]== target){
                res = mid;
                low = mid+1;
            }else if (target < nums[mid]) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return res;
    }
}