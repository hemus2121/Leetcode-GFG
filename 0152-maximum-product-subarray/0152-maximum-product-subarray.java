class Solution {
    public int maxProduct(int[] nums) {
        
        int maxLeft = nums[0];
        int maxRight = nums[0];
        
        // traversal from LEFT traversal
        boolean zeroPresent = false;
        int prod =1;
        for (int i :nums){
            prod = prod * i;
            if (i==0){ // resetting it incoming element is ZERO
                zeroPresent = true;
                prod =1;
                continue;
            }
            maxLeft = Math.max(maxLeft, prod);
        }
        
        //reset prod = 1 for RIGHT traversal
        prod = 1;
        for (int i = nums.length-1;i >=0;i--){
            prod = prod * nums[i];
            if (nums[i]==0){ // resetting it incoming element is ZERO
                zeroPresent = true;
                prod=1;
                continue;
            }
            maxRight = Math.max(maxRight, prod);
        }
        
        return zeroPresent ? Math.max(0, Math.max(maxLeft, maxRight)) : Math.max(maxLeft, maxRight);
    }
}