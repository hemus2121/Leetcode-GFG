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
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class tuple{
    int dist, src, dst;
    tuple (int dist, int src, int dst){
        this.dist =dist;
        this.src = src;
        this.dst = dst;
    }
}

// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        //base case
        if (source[0] == destination[0] && source[1]== destination[1]) return 0;
        
        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int [][] dist = new int [n][m];
        
        for (int [] di: dist){
            Arrays.fill (di,(int)1e9);
        }
        
    
        dist[source[0]][source[1]]=0;
        
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple (0, source[0], source[1]));
        
        int [] dr = {-1, 0, 1,0};
        int [] dc = { 0, 1, 0,-1};
        
        while (!q.isEmpty()){
            tuple t = q.poll();
            int dis = t.dist;
            int r = t.src;
            int c = t.dst;
            
            for (int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                //check boundary 
                if (nr >=0 && nr < n && nc >= 0 && nc <m  && grid [nr][nc]==1 
                &&  1 + dis < dist[nr][nc]  ){
                    dist[nr][nc]= 1 + dis;
                    if ( nr == destination[0] && nc == destination[1]) return dist[nr][nc];
                    q.add( new tuple(dist[nr][nc], nr, nc));
                }
            }
        }
        return -1;
    }
}
