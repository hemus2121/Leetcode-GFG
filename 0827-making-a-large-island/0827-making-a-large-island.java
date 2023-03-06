class DisJointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisJointSet(int n){
        for (int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if (rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }else {
            //both ranks same os u can add any to other segment
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
    
    void unionBySize(int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    } 
}

class Solution {
    private boolean isValid ( int row, int col, int n){
        return ( row >=0 && row < n && col >=0 && col < n);
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisJointSet ds = new DisJointSet(n*n);
        //Step 1: iterate input matrix - to union components
        for (int row =0;row<n;row++){
            for (int col =0; col< n;col++){
                if (grid [row][col]==0) continue;
                 int dr[] = {-1, 0, 1, 0};
                 int dc[] = {0, -1, 0, 1};
                 for (int ind =0;ind< 4;ind++) {
                     int newr = row + dr[ind];
                     int newc = col + dc[ind];
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                     }
                }
            }
        }
        
     //Step 2: convert 0 to 1 and check for max size till now
     int max = 0;
     for(int row=0;row< n;row++){
         for(int col=0;col< n;col++){
             if (grid[row][col]==1) continue;
               int dr[] = {-1, 0, 1, 0};
               int dc[] = {0, -1, 0, 1};
               Set<Integer> uniqueParents = new HashSet<>();
               for (int ind =0;ind< 4;ind++) {
                     int newr = row + dr[ind];
                     int newc = col + dc[ind];
                     if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                            uniqueParents.add(ds.findUPar(newr * n + newc));
                        }
              }
             int totalSize =0;
             for (Integer parents: uniqueParents){
                 totalSize+= ds.size.get(parents);
             }
             //update max 
             max = Math.max(max, totalSize+1);
            }
        }  
        //System.out.println("mx: "+ max);
        //for (int cellNo = 0; cellNo < n * n; cellNo++) {
         //   max = Math.max(max, ds.size.get(ds.findUPar(cellNo)));
        //}
     return max==0? n*n: max;
    }
        
}