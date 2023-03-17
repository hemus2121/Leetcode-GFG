//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        ArrayList<Integer> resultList = new ArrayList<>();
        getSubSetSums(0,0, N, arr, resultList);
        return resultList;
    }
    
    void getSubSetSums(int ind, int sum, int N, ArrayList<Integer> arr, ArrayList<Integer> resultList ){
        if (ind == N){
            resultList.add(sum);
            return ;
        }
        
        //pick 
        getSubSetSums(ind+1, sum + arr.get(ind), N, arr, resultList);
        
        //no pick  case
        getSubSetSums(ind+1, sum, N, arr, resultList);
    }
}