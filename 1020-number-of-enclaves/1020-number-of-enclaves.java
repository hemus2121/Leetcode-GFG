class Pair {
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int [][] visited = new int [n][m];
        
        Queue <Pair>q  = new LinkedList<>();
        
        for (int i =0;i< n;i++){
            for (int j =0;j<m;j++){
                  if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                // if it is a land then store it in queue
                        if (grid[i][j]==1){
                            visited [i][j]=1;
                            q.add(new Pair(i, j));
                        }
                  }
            }
        }
        
        int [] drow = {-1,0,1,0};
        int [] dcol = {0,1,0, -1};
        
        while (!q.isEmpty()){
            Pair tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            
            for (int i =0;i<4;i++){
                int dx = x + drow [i];
                int dy = y + dcol[i];
                
                if ( dx >=0 && dx < n && dy>=0 && dy<m && visited[dx][dy]==0 && grid [dx][dy]==1){
                    visited[dx][dy]=1;
                    q.add(new Pair(dx,dy));
                }
            }
        }
        
        int cnt=0;
        for (int i =0;i< n;i++){
            for (int j =0;j<m;j++){
                if (visited[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}