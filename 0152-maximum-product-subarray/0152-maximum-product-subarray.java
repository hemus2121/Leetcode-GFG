class Solution {
    public int maxProduct(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int prod =1;
        
        // traversal from LEFT traversa
        for (int i :nums){
            prod = prod * i;
            max = Math.max(max, prod);
            if (prod==0) prod =1; // resetting it incoming element is ZERO
        }
        
        //reset prod = 1 for RIGHT traversal
        prod = 1;
        for (int i = nums.length-1;i>=0;i--){
            prod = prod * nums[i];
            max = Math.max(max,prod);
            if (prod==0) prod =1;
        }
        return max;
    }
}