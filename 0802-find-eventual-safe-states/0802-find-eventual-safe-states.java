class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList();
        int V = graph.length;
        int [] indegree = new int [V];
        buildGraph (V, graph, adjList, indegree);
        
        //List<Integer> res = new ArrayList<>();
        return topoSort(V, adjList, indegree);
    }
    
    List<Integer> topoSort(int n, List<List<Integer>> adjList, int [] ind){
      //result place holder
        List<Integer> result = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        
        // add nodes whose indegree is 0
        for (int i =0;i< ind.length;i++){
            if (ind[i]==0) q.add(i);
        }
        
        while (!q.isEmpty()){
            int tmp = q.remove();
            result.add(tmp);
            
            //iterate over adj nodes
            for (int neigh : adjList.get(tmp)){
                ind[neigh]--;
                if (ind[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        
        Collections.sort(result);
        return result;
    }
     void buildGraph(int n, int [][]graph, List<List<Integer>> adjList, int [] ind){
         for (int i =0;i< n;i++){
             adjList.add(new ArrayList<>());
         }
         
          for (int i = 0; i < n; i++) {
            // i -> it  -- reversing edges
            // it -> i
            for (int it : graph[i]) {
                adjList.get(it).add(i);
                ind[i]++;
            }
        }
     }
}