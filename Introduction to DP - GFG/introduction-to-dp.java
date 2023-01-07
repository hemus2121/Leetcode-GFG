//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
   static long mod = 1000000007;
    static long solve(int n,long []dp){
        //1. Express the problem in term of index/base case
        if(n==0 || n==1)return n;
        //2. Check it is already computed or not
        if(dp[n]!=-1)return dp[n];
        //3. do all stuffs on that index
        return dp[n]= (solve(n-1,dp)+solve(n-2,dp))%mod;
    }
    static long topDown(int n) {
        long [] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

   /* static long bottomUp(int n) {
        long [] dp = new long[n+1];
        //base case
        dp[0]= 0; dp[1]=1;
        //express the states for the for loop
        for(int i =2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        return dp[n];
    }*/
    
    // Space Optimized code 
    static long bottomUp(int n) {
        long [] dp = new long[n+1];
        //base case
        //dp[0]= 0; dp[1]=1;
        long prev2 =0, prev1=1, curr=0;
        //express the states for the for loop
        for(int i =2;i<=n;i++){
           curr = (prev2+ prev1)%mod;
           prev2= prev1;
           prev1= curr;
        }
        return prev1%mod;
    }
}
