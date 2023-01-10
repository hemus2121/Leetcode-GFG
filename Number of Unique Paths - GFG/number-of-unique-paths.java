//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int [][] dp = new int [a][b];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
       // return computeTopDown(a-1, b-1, dp);
      // return computeBottmUp(a, b, dp);
      return computeBottmUpOpt(a, b);
    }
    
    //Top Down
    static int computeTopDown(int i, int j, int [][]dp){
        if (i==0 && j==0) return 1;
        if ( i<0 || j <0) return 0;
        
        // if already found 
        if (dp[i][j]!=-1) return dp[i][j];
        int up = computeTopDown(i-1, j, dp);
        int left = computeTopDown(i, j-1, dp);
        return dp[i][j] = up + left;
    }
    
    //Bottom up
    static int computeBottmUp(int m, int n, int [][]dp){
        for (int i =0;i< m;i++){
            for (int j =0;j<n;j++){
                // filling 1st cell of left most
                if (i==0 &&j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0, left=0;
                if ( i>0) up = dp[i-1][j];
                if (j >0) left = dp[i][j-1];
               
                dp[i][j] = left+up;
            }
        }
        return dp[m-1][n-1];
    }
    
     //Bottom up - Optimized
    static int computeBottmUpOpt(int m, int n){
        int prev[]=new int[n]; // previous row
        
        for (int i =0;i< m;i++){
            int temp[]=new int[n];
            for (int j =0;j<n;j++){
                // filling 1st cell of left most
                if (i==0 &&j==0){
                    temp[j]=1;
                    continue;
                }
                int up=0, left=0;
                if (i>0) up = prev[j]; // previous row
                if (j >0) left = temp[j-1]; // current row previous column
               
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}