//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int first = bottomUpOptimised(arr, 0, n-1);
        //System.out.println ("first:" + first);
        int second = bottomUpOptimised(arr, 0, n);
        //System.out.println ("second:" + second);
        return Math.max(first, second);
    }
    
    int bottomUpOptimised(int []arr, int start, int end){
        
        int prev = arr[start];
        int prev2=0;
        
        for (int i = 1;i <end;i++){
            int pick = arr[i];
            if (i >1){
                pick += prev2;
            }
            int nonpick = 0 + prev;
            int curr = Math.max(pick, nonpick);
            prev2 =prev;
            prev=curr;
        }
        return prev;
    }
}