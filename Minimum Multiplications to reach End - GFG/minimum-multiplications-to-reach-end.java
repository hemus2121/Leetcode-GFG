//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int node, step;
    Pair (int node, int step){
        this.node = node;
        this.step =step;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int [] dist = new int [100000];
        Arrays.fill (dist, (int)(1e9));
        int mod = (int)100000;
        
        Queue <Pair> q= new LinkedList<>();
        q.add(new Pair(start, 0));
        
        while (!q.isEmpty()){
            Pair temp = q.poll();
            int node = temp.node;
            int step = temp.step;
            
            //iterate for all array elements
            for (int a: arr){
               int num = (a * node) % mod; 
                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if (step +1 < dist[num] ){
                    dist[num] = step+1;
                    //check if target is reached return number of steps
                    if (num == end) return (step +1)%mod;
                    q.add(new Pair(num, step+1));
                }
            }
        }
        return -1;
    }
}
