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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
         List<List<Integer>> adjList = new ArrayList<>();
        int [] ind = new int [V];
        buildGraph(V, adj, adjList, ind);
        
        return topoSort(V, adjList, ind);
    }
    
    void buildGraph(int V, List<List<Integer>> adj, List<List<Integer>> adjList, int [] ind ){
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i =0;i< V;i++){
            for (int it : adj.get(i)){
                adjList.get(it).add(i);
                ind[i]++;
            }
        }
    }
    
    List<Integer> topoSort(int V,   List<List<Integer>> adjList, int [] ind){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i =0;i< V;i++){
            if (ind[i]==0){
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()){
            int temp = q.poll();
            res.add(temp);
            
            for (int neigh: adjList.get(temp)){
                ind[neigh]--;
                if (ind[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
