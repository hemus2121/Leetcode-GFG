class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        // Build adjList
        List<List<Integer>> adjList = new ArrayList<>();

        // we need array to hold INDEGREE count for each node init with MAX value
        int [] indegree = new int [numCourses];
        buildGraph(numCourses, prerequisites, adjList, indegree);

/*        List<Integer> resultList = new ArrayList<>();
        topoSortData(numCourses, indegree,adjList, resultList);
        
        
        // if(idx!=numCourses) return new int[0];
        //else return ans;
        
        if (resultList.size() == numCourses){
            return resultList.stream().mapToInt(val -> val).toArray();
        }
        return new int[0]; 
        */
       
        
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++) if(indegree[i] == 0) que.add(i);
        int[] ans = new int[numCourses];
        int idx=0;
        
        while(que.size()!=0){
            int rem = que.poll();
            ans[idx++] = rem;
            List<Integer> get = adjList.get(rem);
            for(int ele : get){
                indegree[ele]--;
                if(indegree[ele] == 0) que.add(ele);
            }
        }
        if(idx!=numCourses) return new int[0];
        else return ans;
    }
    
    void buildGraph(int numCourses, int[][] prerequisites, List<List<Integer>> adjList, int []indegree){
       
        for(int i=0; i<numCourses; i++) 
            adjList.add(new ArrayList<>());
        
       
        for(int i=0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
    }
    
   /* void buildGraph(int n, int [][]pre,List<List<Integer>> adjList, int[] indeg ){
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) 
            graph.add(new ArrayList<>());
        
        
        int[] indegree = new int[n];
        for(int i=0; i<pre.length; i++){
            graph.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
    } */
    
    /* void topoSortData(int n, int[] indegree, List<List<Integer>> adjList,List<Integer> resList){
        
         Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) 
                que.add(i);
        }
      
 
        
        while(que.size()!=0){
            int rem = que.poll();
            resList.add(rem);
            List<Integer> get = adjList.get(rem);
            for(int ele : get){
                indegree[ele]--;
                if(indegree[ele] == 0) 
                    que.add(ele);
            }
        }
    } */
    
}