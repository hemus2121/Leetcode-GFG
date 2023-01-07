//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    
     static int mod = 1000000007;
    int countWays(int n)
    {
        
        // your code here
        int [] dp = new int [n+1];
        Arrays.fill(dp, -1);
        //return computetop(dp, n);
        return computebottom(dp, n);
    }
    
        int computetop(int [] dp, int n){
            if(n <=2) return n;
            if (dp[n] != -1) return dp[n];
            return dp[n] = (computetop(dp, n-1) + computetop(dp, n-2))%mod;
        }
        
        int computebottom(int []dp, int n){
            if (n==1) return 1;
           dp[0]=1;
           dp[1]=1;
           dp[2]=2;
           
           for (int i=3;i<=n;i++){
               dp[i] = (dp[i-1] + dp[i-2])%mod;
           }
           return dp[n];
        }
    
}

