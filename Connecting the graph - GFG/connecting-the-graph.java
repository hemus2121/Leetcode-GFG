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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

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

class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        int countExtraEdges=0;
        for (int [] edg : edge){
            if (ds.findPar(edg[0])== ds.findPar(edg[1])){
                countExtraEdges++;
            }else ds.unionBySize(edg[0], edg[1]);
        }
        
        //get the count of unique parent that gives number of componenets
        int countOfComponents=0;
        for (int i=0;i< n;i++){
            if (ds.parent.get(i)==i) countOfComponents++;
        }
        int ans  = countOfComponents - 1;
        return (countExtraEdges >= ans) ? ans: -1;
    }
}