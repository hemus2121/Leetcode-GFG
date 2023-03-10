class Solution {
    
    private int timer = 1;
    void dfs(int node, int parent, int [] vis,  List <List<Integer>> adjList , int [] tin, int []low, List<List<Integer>> bridges){
        
        vis[node]=1;
        tin[node]= low[node]=timer;
        timer++;
        //iterate adj nodes
        for (Integer neighbour : adjList.get(node)){
             if (neighbour == parent) continue;
             if (vis[neighbour]==0){
                 dfs(neighbour, node, vis, adjList,tin, low,bridges);
                 low[node] = Math.min(low[node], low[neighbour]);
                 //most critical
                 if (low[neighbour] > tin[node]){
                     bridges.add(Arrays.asList(neighbour, node));
                 }
             }else {
                 low[node] = Math.min(low[node], low[neighbour]);
             }
        }
        
    }
    void buildGraph(int n , List<List<Integer>> connections,   List <List<Integer>> adjList ){
        for (int i =0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for (List<Integer> con: connections){
            int u = con.get(0);
            int v = con.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }
    
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List <List<Integer>> adjList = new ArrayList<>();
        buildGraph(n, connections, adjList);
        
        // placeholders
        int [] vis = new int[n];
        int [] tin = new int[n];
        int [] low = new int[n];
        //Result place holder
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adjList, tin, low, bridges);
        return bridges;
    }
}