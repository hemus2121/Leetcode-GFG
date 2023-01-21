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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int x,y,time;
    Pair (int x, int y, int time ){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int [] [] visited = new int [n][m];
        int cntFresh =0;
         Queue <Pair> q = new LinkedList<>();
         for (int i =0;i< n;i++){
             for (int j =0;j< m;j++){
                 if (grid[i][j]== 2){
                     visited [i][j]=2;
                     q.add(new Pair(i,j, 0));
                 }
                 // count fresh oranges
                if (grid[i][j] == 1) cntFresh++;
             }
         }
         
        int tm = 0;
        // delta row and delta column
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1}; 
        int cnt = 0;
        
        while (!q.isEmpty()){
            Pair tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int time = tmp.time;
            tm = Math.max(tm, time);
            
            for (int i=0;i< 4;i++){
                int dx = x + drow[i];
                int dy = y + dcol[i];
                
                // condi
                while ( dx >=0 && dx < n && dy >=0 && dy <m && visited[dx][dy]==0 &&grid[dx][dy] == 1){
                    visited[dx][dy]=2;
                    q.add(new Pair(dx, dy, time +1));
                    cnt++;
                }
            }
        }
         if (cnt != cntFresh) return -1;
         return tm ;
    }
}