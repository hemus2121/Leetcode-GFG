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
    
    int findUPar(int node){
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
    
    public int removeStones(int[][] stones) {
       int maxCol = 0;
       int maxRow = 0;
       HashMap<Integer,Integer> stoneNodes = new HashMap<>();
       for(int []arr:stones){
           maxCol = Math.max(maxCol,arr[1]);
           maxRow = Math.max(maxRow,arr[0]);
           
       }
       DisJointSet ds = new DisJointSet(maxRow+maxCol+1);
       
       for(int []arr:stones){
          int u = arr[0];
          int v = arr[1]+maxRow+1;
          ds.unionByRank(u,v);
          stoneNodes.put(u,1);
          stoneNodes.put(v,1);
          
       }
        
       int count = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                count++;
            }
        }
       
       return stones.length-count;
    }
}