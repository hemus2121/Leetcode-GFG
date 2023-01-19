//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int cur;
    int par;
    Pair (int cur, int par){
        this.cur = cur;
        this.par = par;
    }
}
class Solution {
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean visited[] = new boolean[V];
          
        // we need to travers for all components
        for (int i =0;i<V;i++){
            if (visited[i]== false){
                if (bfsCycle(i, adj, visited)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean bfsCycle(int node,  ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,-1)); //starting node 
        vis[node]=true; //making current node as visited
        
        while (!q.isEmpty()){
            Pair temp = q.poll();
            int curr = temp.cur;
            int par = temp.par;
            
            for (int neigh : adj.get(curr)){
                if (vis[neigh] == false){
                    vis[neigh]= true;
                    q.add(new Pair(neigh, curr));
                }else if (neigh != par){
                    return true;
                }
            }
        }
        return false;
    }
    
    
}