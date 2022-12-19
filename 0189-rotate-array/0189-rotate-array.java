class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        //algo 3 steps  - ROTATE RIGHT
        // 1. Reverse the last k elements of the array
        // 2. Reverse the first n-k elements of the array.
        // 3. Reverse the whole array.
         k = k%n;
        //rotateArray(nums, 0, n-k-1);
        //rotateArray(nums, n-k, n-1);
        rotateArray(nums, n-k, n-1);
        rotateArray(nums, 0,  n-k-1);
        rotateArray(nums, 0, n-1);
    }
    
    void rotateArray(int [] nums, int start, int end){
        while (start <end ){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}