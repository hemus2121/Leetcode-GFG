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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        Map <String, Integer> mapMailNode = new HashMap<String, Integer>();
        
        for (int i =0;i< n;i++){
            for ( int j = 1;j< accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if ( !mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                }else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        
        //iterate mailMapNode Map to identify ultimate parent 
        List<String> [] mergedMail = new ArrayList[n];
        for (int i= 0;i<n;i++){
            mergedMail[i] = new ArrayList<String>();
        }
        for (Map.Entry<String,Integer> entrySet : mapMailNode.entrySet()){
             String mail = entrySet.getKey();
             int node = ds.findUPar(entrySet.getValue());
             mergedMail[node].add(mail);
        }
        
         //final block to merge name and common email ids
         List<List<String>> ans = new ArrayList<>();
         for (int i =0;i<n;i++){
              if (mergedMail[i].size() == 0) continue; // skip if not mail is found for node
               //sort the email id
               Collections.sort(mergedMail[i]);
               List<String> temp = new ArrayList<>();
               temp.add(accounts.get(i).get(0));// get actual name from input data
               //temp.addAll(mergedMail[i]);
               for (String s : mergedMail[i]){
                   temp.add(s);
               }
               ans.add(temp);
         }
        return ans;
    }
}