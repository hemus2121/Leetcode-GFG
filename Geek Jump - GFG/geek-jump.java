//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int [] dp = new int [N];
        Arrays.fill(dp, -1);
        return getMinEner(arr, N-1 , dp);
    }
    
    int getMinEner(int [] arr, int N, int [] dp){
        // base case
        if (N==0) return 0;
        if (dp[N] !=-1) return dp[N];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = getMinEner(arr, N-1, dp) + Math.abs(arr[N]-arr[N-1]);
        if (N >1){
            jumpTwo = getMinEner(arr, N-2, dp) + Math.abs(arr[N]-arr[N-2]);
        }
        return dp[N] = Math.min(jumpOne, jumpTwo);
    }
}