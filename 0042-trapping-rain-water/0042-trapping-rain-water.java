class Solution {
    public int trap(int[] height) {
        
        //w ith extrax space
        int n = height.length;
        
        // we need left max and right max till that place
        int [] leftmax = new int [n];
        int [] rightmax = new int[n];
        
        //compute left max
        leftmax[0] =height[0];
        for (int i =1;i< n;i++){
            leftmax[i] = Math.max(leftmax[i-1], height[i]) ;
        }
        
        //compute right max
        rightmax[n-1] = height[n-1];
        for (int i = n-2;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1], height[i]);
        }
        
        //total water - take minimum of both side and reduce current height
        int totalWater=0;
        for (int i =0;i<n;i++){
            totalWater += Math.min(leftmax[i], rightmax[i])- height[i];
        }
        return totalWater;
        
    }
}