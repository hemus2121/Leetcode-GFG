//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        //create dp array
        int [] [] dp = new int [N][sum+1];
        for (int [] row :dp){
            Arrays.fill(row, -1);
        }
       // return computeTopDown(N-1, arr, sum, dp);
       return computeBottomUP(N, arr, sum);
    }
    
    static boolean computeTopDown(int N, int arr[], int target, int [][]dp){
        //base case 
        if (target==0) return true;
        if (N==0) return arr[0]== target;
        
        //check if already exists
        if (dp[N][target] !=-1)
            return dp[N][target]==0?false:true;
        
        // non pick cases 
        boolean nonpick = computeTopDown(N-1, arr, target,dp );
        
        //pick case
        boolean pick = false;
        if (arr[N] <= target){
             pick = computeTopDown(N-1, arr, target-arr[N], dp);
        }
        dp[N][target]=nonpick||pick?1:0;
        return nonpick||pick;
    }
    
    static boolean computeBottomUP(int N, int arr[], int target){
        
       boolean [][] dp = new boolean[N][target+1];
       //make 1st column is true
        for (int i=0;i< N;i++){
            dp[i][0]= true;
        }
        
        if (arr[0] <= target){
            dp[0][arr[0]] = true;
        }
        
        for (int ind=1;ind<N;ind++){
            for (int tg=1;tg <=target; tg++){
                
                boolean notpick = dp[ind-1][tg];
                
                boolean pick = false;
                if (arr[ind] <= tg){
                      pick = dp[ind-1][tg-arr[ind]];
                }
                dp[ind][tg] = notpick || pick;
            }
        }
        return dp[N-1][target];
    }
}