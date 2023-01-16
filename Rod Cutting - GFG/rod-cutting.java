//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
         int dp[][]=new int[n][n+1];
         for (int [] row: dp){
             Arrays.fill(row, -1);
         }
        // return computeTopdown(price, n-1, n, dp);
        return computeBottomUp(price, n);
    }
    
    int computeTopdown(int [] price, int ind, int N, int [][] dp){
        //base case
        if (ind==0) {
            return price[0] * N;
        }
        
        if (dp[ind][N] !=-1) return dp[ind][N];
        
        int notTake =  0+ computeTopdown(price, ind-1, N, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind +1;
        if (rodLength <=N )
            take = price[ind] + computeTopdown(price, ind, N-rodLength, dp);
        
        return dp[ind][N] = Math.max(take, notTake);
    }
    
    int computeBottomUp(int [] price, int N){
        int dp[][]=new int[N][N+1];

    
        for(int i=0; i<=N; i++){
            dp[0][i] = i*price[0];
        }
    
        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){
                
             int notTaken = 0 + dp[ind-1][length];
    
             int taken = Integer.MIN_VALUE;
             int rodLength = ind+1;
             if(rodLength <= length)
                taken = price[ind] + dp[ind][length-rodLength];
        
             dp[ind][length] = Math.max(notTaken,taken);   
            }
        }
        return dp[N-1][N];
    }
}