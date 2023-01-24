class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int [] color = new int [n];
        Arrays.fill(color, -1);
        

        
        /// for connected components
        for (int i =0;i<n;i++){
            if(color[i] == -1) {
                if(isDFS(i, 0, color, graph) == false) return false; 
            }
        }
        return true;
        
    }
     boolean isDFS(int node, int col, int [] color, int [][]graph){
        color[node] = col; 
        
        // traverse adjacent nodes
        for(int it : graph[node]) {
            // if uncoloured
            if(color[it] == -1) {
                if(isDFS(it, 1 - col, color, graph) == false) return false; 
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false; 
            }
        }
        return true;      
     }
    
}