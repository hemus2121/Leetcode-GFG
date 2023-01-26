//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adjList =new ArrayList<>();
        int [] dist = new int [n];
        Arrays.fill (dist,(int)1e9);
        dist[src]=0;
        buildGraph(adjList, n, m, src, edges);
        
        // BFS traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while (!q.isEmpty()){
            int node = q.poll();
            for (int neigh : adjList.get(node)){
                if (dist[node]+1  < dist[neigh]){ // we need minimum distance
                    dist[neigh] = dist[node]+1;
                    q.add(neigh);
                }
            }
        }
        
        for (int i =0;i< dist.length;i++){
            if (dist[i]== (int)1e9){
                dist[i] =-1;
            }
        }
        return dist;
    }
        
     void buildGraph( List<List<Integer>> adjList, int n, int m, int src,int[][] edges){
        //build adj list
        for (int i =0;i< n;i++){
            adjList.add (new ArrayList<>());
        }
        
        for (int [] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
    }
}