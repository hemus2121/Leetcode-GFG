//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class DisjointSet{
    List<Integer> rank = new ArrayList<Integer>();
    List<Integer> size = new ArrayList<Integer>();
    List<Integer> parent = new ArrayList<Integer>();
    
    //constructor
    public DisjointSet(int n){
        for (int i =0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i); // every node is parent of itself
        }
    }
    
    public int findPar(int node){
        if (node== parent.get(node)) return node;
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if (ulp_u == ulp_v) return ;
        //3 conditions we need to add short to longer
        if (rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if (rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else {// both ranks are same
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
         if (ulp_u == ulp_v) return ;
         if (rank.get(ulp_u)< rank.get(ulp_v)){
             parent.set(ulp_u, ulp_v);
             size.set(ulp_u, size.get(ulp_u)+ size.get(ulp_v));
         }else {
             parent.set(ulp_v, ulp_u);
             size.set(ulp_v, size.get(ulp_u)+ size.get(ulp_v));
         }
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    int minWt=0;
	    Arrays.sort(edges, (e1, e2) -> (e1[2]- e2[2]));
	    
	    DisjointSet ds = new DisjointSet(V);
	    for (int [] edge : edges){
	        if (ds.findPar(edge[0]) != ds.findPar(edge[1])){
	            ds.unionBySize(edge[0], edge[1]);
	            minWt += edge[2];
	        }
	    }
	    return minWt;
	}
}