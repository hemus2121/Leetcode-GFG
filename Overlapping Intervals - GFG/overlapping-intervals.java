//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        
          List <int []> resList = new ArrayList<>();
          // boundary cases
          if (Intervals == null || Intervals.length==0)
            return  resList.toArray (new int [0][]);
            
            //sort based on 1st parameter
            Arrays.sort(Intervals, (a,b)-> (a[0]-b[0]));
            
            //take reference 
            int start = Intervals[0][0];
            int end = Intervals[0][1];
            
            //iterate current intervals
            for (int [] in : Intervals){
                if (in[0] <= end){ // incoming interval start is less than curren end
                    end = Math.max(end,in[1]);
                }else {
                    resList.add (new int []{ start, end});
                    start = in[0];
                    end = in[1];
                }
            }
            
            resList.add(new int []{start,end});
            return resList.toArray(new int[0][1]);
    }
}