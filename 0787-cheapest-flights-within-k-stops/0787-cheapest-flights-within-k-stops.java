class Pair {
    int node, wt;
    Pair (int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
class Tuple {
    int stop,node,cost;
    Tuple (int stop, int node, int cost){
        this.stop = stop;
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    
    void buildGraph(int n , int [][] flights, List<List<Pair>> adjList){
       
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>()); 
        }
        for (int [] flight: flights){
            adjList.get(flight[0]).add (new Pair(flight[1], flight[2]));
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // build graph 
        List<List<Pair>> adjList = new ArrayList<>();
        buildGraph(n, flights, adjList);
                
       // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating 
        // the no. of nodes between src and current node.
        Queue<Tuple> q = new LinkedList<>(); 
        q.add(new Tuple(0, src, 0));

        // Distance array to store the updated distances from the source. 
        int[] dist = new int[n]; 
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0; 
        
       while(!q.isEmpty()) {
            Tuple it = q.poll(); 
            int stops = it.stop; 
            int node = it.node; 
            int cost = it.cost; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue; 
           
            for(Pair pair: adjList.get(node)) {
                int adjNode = pair.node; 
                int edW = pair.wt; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW; 
                    q.add(new Tuple(stops + 1, adjNode, cost + edW)); 
                }
            }
        }
        return dist[dst] == (int)(1e9) ? -1: dist[dst];  
    }
}