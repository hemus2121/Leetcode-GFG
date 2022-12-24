//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        
        //corner case
        if (arr == null || N<=1) return new ArrayList<Integer>() ;
        
        int breakingIndex = arr.length-2;
        //to get 1st dip
        while (breakingIndex >= 0 && arr[breakingIndex] >= arr[breakingIndex+1]){
            breakingIndex--;
        }
        
        if (breakingIndex>=0){
            //again iterate from back to get next greater element
            int index = arr.length-1;
            while (arr[index] <= arr[breakingIndex]){
                index--;
            }
            //swap elements
            swap (arr, breakingIndex, index);
        }
         //Reverse values from breakpointIndex+1 to end of Array
         reverse(arr, breakingIndex+1, arr.length-1);
         
        //List<Integer> integerList= Arrays.asList(arr);
       // //return integerList;
        //List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //return list;
        List<Integer> list = new ArrayList();
        for (int a : arr){
            list.add(a);
        }
        return list;
    }
    
    static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void reverse(int [] arr, int i, int j){
        while (i < j){
            swap (arr, i++, j--);
        }
    }
}