class Solution {
    
       int [] dx = { 0, 1, 0, -1 };
       int [] dy = { 1, 0, -1, 0 };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     
        int initColor = image[sr][sc];
        int [][] ans = image;
        dfs (image, sr, sc, color, initColor, ans);
        return ans;
    }
    
    void dfs(int [][] image, int sr, int sc, int newColor, int initColor, int [][] ans){
        //mark current cell wit new color
        //fill answer will new color
        ans [sr][sc ] = newColor;

        int n = image.length;
        int m = image[0].length;
        //iterate all 4 directions
        for (int d =0;d < 4;d++){
            int nrow = sr + dx[d];
            int ncol = sc + dy[d];

            //check conditions
            if (nrow >=0 && ncol >=0 && nrow <n && ncol <m && image[nrow][ncol] == initColor && ans[nrow][ncol] !=newColor){
                dfs(image, nrow, ncol, newColor, initColor, ans);
            }
        }
    }
}