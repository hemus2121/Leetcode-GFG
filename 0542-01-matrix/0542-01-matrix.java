class Node {
    int first, second, dist;
    Node(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}

class Solution {
    
    
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length; 
	    int m = mat[0].length; 
        int [][] visited = new int [n][m];
        int [][] dist = new int [n][m];
        
        //multi source BFS
        Queue <Node> q = new LinkedList<Node>();
        
        //iterate matrix and fill the starting nodes
        for (int i =0;i< n;i++){
            for (int j =0;j<m;j++){
                if (mat[i][j]==0){
                    q.offer(new Node(i,j, 1));
                    visited [i][j]=1;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
	    
        
        while (! q.isEmpty()){
            Node temp = q.poll();
            int x = temp.first;
            int y = temp.second;
            int dis = temp.dist;
            dist[x][y] = dis-1;
            
            for(int i = 0;i<4;i++) {
                int dx = x + delrow[i];
                int dy =  y + delcol[i];
                while (dx >=0 && dx <n && dy >=0 && dy <m && visited[dx][dy]==0){
                    visited[dx][dy]=1;
                    q.add(new Node(dx, dy, dis+1));
                }
            }
        }
        return dist;
    }
}