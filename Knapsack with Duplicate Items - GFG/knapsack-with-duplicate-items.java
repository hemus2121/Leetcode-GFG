//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int [][] dp = new int [N][W+1];
        for (int [] row: dp){
            Arrays.fill(row, -1);
        }
        return computeTopDown(N-1, W, val, wt, dp);
    }
    
    static int computeTopDown(int N, int W, int[] val, int [] wt, int [][] dp){
        //base case
        if (N==0){
           // if (wt[N]<=W){
            return ((int)(W/wt[0])) * val[0];
           // }
        }
        
       if(dp[N][W]!=-1) return dp[N][W];
        
        int notTake = 0 + computeTopDown(N-1, W, val, wt, dp);
        int take=Integer.MIN_VALUE;
        if (wt[N]<=W){
            take = val[N] + computeTopDown(N, W-wt[N], val, wt, dp);
        }
        return dp[N][W] = Math.max(take, notTake);
    }
}