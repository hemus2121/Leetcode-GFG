class Solution {
    public int climbStairs(int n) {
         int [] dpArray = new int [n+1];
       return climbStairsIter(n, dpArray);
        //return climbStairsRecu(n, dpArray);
    }
    
    int climbStairsRecu(int n, int [] dpArray){
        //base case
        if (n<=2) return n;
        // if found return from dp array
        if (dpArray[n] !=0) return dpArray[n];
        
        dpArray[n] = climbStairsRecu(n-1, dpArray) + climbStairsRecu(n-2,dpArray);
        return dpArray[n];
    }
    
    int climbStairsIter(int n, int [] dpArray){
        if (n==1) return 1;
        dpArray[0]=1;
        dpArray[1]=1;
        dpArray[2]=2;
        for (int i=3;i<=n;i++){
            dpArray [i] = dpArray [i-1] + dpArray[i-2];
        }
        return dpArray[n];
    }
}