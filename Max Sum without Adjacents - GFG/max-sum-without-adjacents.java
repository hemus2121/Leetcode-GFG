//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        //return computeTopDown(arr,n-1,dp);
        //return computeBottomUp(arr,n, dp);
        return computeBottomUpOptimized(arr, n, dp);
    }
    
    //Top up approach
    int computeTopDown(int [] arr, int ind, int [] dp){
        // base case
        if (ind==0) return arr[0];
        if (ind<0) return 0;
        
        //if already found
        if (dp[ind] != -1) return dp[ind];
        
        //actual logic
        int pick = arr[ind] + computeTopDown(arr, ind-2, dp);
        int notPick = computeTopDown(arr, ind-1, dp);
        return dp[ind]=Math.max(pick, notPick);
    }
    
    //Bottom up approach
    int computeBottomUp(int [] arr, int n , int []dp){
        dp[0]= arr[0];
        for (int ind=1; ind<n;ind++){
            int Pick = arr[ind];
            if (ind >1){
                Pick += dp[ind-2];
            }
            int nonPick = 0 + dp[ind-1];
            dp[ind] = Math.max(Pick, nonPick);
        }
        return dp[n-1];
    }
    
    // Bottomup -Optimized
    int computeBottomUpOptimized(int [] arr, int n , int []dp){
        
        int prev=arr[0];
        int prev2=0, curr;
    
        for (int ind=1; ind<n;ind++){
            int Pick = arr[ind];
            if (ind >1){
                Pick += prev2;
            }
            int nonPick = 0 + prev;
            curr = Math.max(Pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    
    
}