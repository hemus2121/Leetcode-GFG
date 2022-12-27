//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
   
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor=0;
        
        /* Get the xor of all array elements  */
        for (int a : arr ){
            xor = xor ^ a;
        }
        
        /* XOR the previous result with numbers from 1 to n*/
        for (int i =1;i<=n;i++){
            xor = xor ^ i;
        }
        
        /* Get the rightmost set bit in set_bit_no */
        int setBit = xor & ~(xor-1);
        
         /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        int x=0, y=0;
        
        for (int a: arr){
           if ((a & setBit) != 0)
                x = x ^ a; 
            else
                y = y ^ a; 
        }
        
        for (int i =1;i<= n;i++){
             if ((i & setBit) != 0)
                x = x ^ i; 
            else
                y = y ^ i; 
        }
        
        //System.out.println ("x=" +x + "y="+y);
        // now we need to do additional check to separate out repeting and missing elements
        int [] res = new int [2];
        for (int a : arr){
            if (x == a){
                return new int [] {x, y};
            }
        }
        return new int [] {y, x};
    }
}