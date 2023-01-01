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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    
    int binary (int [] arr, int n, int target){
        int low = 0, high =n-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid]== target){
                return mid;
            }else if (target < arr[mid]){
                high = mid-1;
            }else low = mid+1;
        }
        return -1;
    }
    int count(int[] arr, int n, int x) {
        // code here
        int getIndex = binary (arr, n, x);
        if (getIndex ==-1) return 0;
        
        // counting logic start starts here
        int count =1;
        
        // count left side
        int left = getIndex-1;
        while (left >=0 && arr[left]== x){
            count++;
            left--;
        }
        
        
        //count right
        int right = getIndex+1;
        while (right < n && arr[right] ==x){
            count++;
            right ++;
        }
        
        return count;
    }
}