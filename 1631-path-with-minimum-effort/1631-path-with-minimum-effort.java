class tuple {
    int dist, x,y;
    public tuple(int dist, int x, int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
       PriorityQueue<tuple> pq = 
        new PriorityQueue<tuple>((x,y) -> x.dist - y.dist);
       
        
        int [][] dist = new int [n][m];
        for (int [] d : dist){
            Arrays.fill(d, (int)(1e9));
        }
        
        dist [0][0]=0;
        pq.add(new tuple(0,0,0));
        
        int dx[] = {-1, 0, 1, 0}; 
        int dy[] = {0, 1, 0, -1}; 
        
        while (pq.size() != 0){
            tuple tp = pq.poll();
            int currDis = tp.dist;
            int row = tp.x;
            int col = tp.y;
            
            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
             if(row == n-1 && col == m-1) return currDis; 
            
            for (int i =0;i< 4;i++){
                int newr = row + dx[i];
                int newc = col + dy[i];
                
                //boundary cond
                if (newr >=0 && newr <n && newc >=0 && newc < m ){
                    
                    // Effort can be calculated as the max value of differences 
                    // between the heights of the node and its adjacent nodes.
                    int newDist = 
                    Math.max(
                        Math.abs(heights[row][col] - heights[newr][newc]), currDis); 
                    
                    //System.out.println("newEffort"+newEffort);
                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if(newDist < dist[newr][newc]) {
                        dist[newr][newc] = newDist; 
                        pq.add(new tuple(newDist, newr, newc)); 
                    }
                }
            }
        }
        return 0;
    }
}