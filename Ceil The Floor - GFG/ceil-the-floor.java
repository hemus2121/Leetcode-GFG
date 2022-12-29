//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

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

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        Arrays.sort(arr);
        int floor = getFloor(arr, n, x);
        int ceil = getCeil(arr, n, x);
        return new Pair (floor, ceil);
    }
    
    int getFloor(int []arr, int n, int x){
        int start=0 ,end = n-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid]== x) return arr[mid];
            else if (arr[mid] < x) start = mid+1;
            else end = mid-1;
        }
        return (end <0) ? -1: arr[end];
    }
    
    int getCeil(int [] arr, int n, int x){
        
        //if (x > arr[n-1]) return -1; //most critical step
        int start=0, end = n-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid]== x) return arr[mid];
            else if (arr[mid]< x ) start = mid+1;
            else end = mid-1;
        }
        return (start > n-1)? -1: arr[start];
    }
        
}
