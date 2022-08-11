class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dpArray = new int[cost.length+1];
        int n = cost.length;
        return  compute(cost, dpArray, n);
    }
    
    int compute(int [] cost, int []dpArray, int n){
        
        if (n<=1) return 0;
        
        if (dpArray[n] !=0) return dpArray[n];
        //main logic
        int downone = cost[n-1]+ compute(cost,dpArray, n-1);
        int downtwo = cost[n-2]+ compute(cost,dpArray, n-2);
            
        dpArray[n] =  Math.min(downone, downtwo);
        return dpArray[n];
    }
}