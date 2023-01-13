//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int [] [] dp = new int [n][W+1];
         for (int [] row : dp){
             Arrays.fill(row, -1);
         }
         //return computeTopDown(W,wt, val, n-1, dp);
         return computeBottomUp(W,wt, val, n, dp);
    } 
    
    static int computeTopDown(int W, int [] wt, int [] val, int n, int [][]dp){
        //base case- index is zer
        if (n==0){
            if (wt[0] <=W) return val[0];
            else return 0;
        }
        
        //check if already found
        if (dp[n][W] != -1) return dp [n][W];
        
        int notTaken = 0 + computeTopDown(W, wt, val, n-1, dp);
        int taken = Integer.MIN_VALUE;
        if (wt[n] <=W){
            taken = val[n] + computeTopDown(W-wt[n], wt, val, n-1, dp);
        }
        return dp[n][W] = Math.max(notTaken, taken);
    }
    
    static int computeBottomUp(int W, int [] wt, int [] val, int n, int [][]dp){
        
         for (int [] row : dp){
             Arrays.fill(row, 0);
         }
        //fill 1st row 
        for (int i = wt[0];i<=W;i++){
            dp[0][i] = val[0];
        }
        
        //iterate other 
        for (int ind =1;ind<n;ind++){
            for (int cap=0;cap<=W;cap++){
                int notTaken = 0 + dp[ind-1][cap];
                
                int taken = Integer.MIN_VALUE;
                if (wt[ind]<=cap){
                    taken = val[ind] + dp[ind-1][cap-wt[ind]];
                }
                dp[ind][cap]= Math.max(notTaken, taken);
            }
        }
        return dp[n-1][W];
    }
}


