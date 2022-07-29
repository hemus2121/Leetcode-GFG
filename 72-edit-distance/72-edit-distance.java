class Solution {
     int [] [] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int [ m+1][n+1];
        return computeRecur(word1,word2, m,n);
    }
    
    int computeRecur(String word1, String word2, int m, int n ){
        
        //base case - if any strign is empty return appended string
        if (m*n==0){
            return m+n;
        }
        
        //check if present already
        if (dp[m][n] !=0) return dp[m][n];
        
        if (word1.charAt(m-1)== word2.charAt(n-1)){
            dp [m][n] = computeRecur(word1,word2, m-1, n-1);
        }
        else{
            // 3 conditions - insert, delete and replace
            int replace = computeRecur(word1, word2, m-1, n-1);
            int delete = computeRecur(word1, word2, m-1, n);
            int insert = computeRecur(word1, word2, m, n-1);
            dp[m][n] = 1+ Math.min(replace, Math.min(delete, insert));
        }
        return dp[m][n];
    }
    
    int computeItera(String word1,String word2, int m, int n){
         //setting 1st column
            for (int i =0;i<=m;i++){
                dp[i][0]=i;
            }

            //setting 1st row
            for(int j=0;j<=n;j++){
                dp[0][j]=j;
            }

            for (int i =1;i<=m;i++ ){
                for (int j=1;j<=n;j++){
                    if (word1.charAt(i-1)== word2.charAt(j-1)){
                        dp[i][j] =  dp[i-1][j-1];
                    }else {
                        int replace = dp [i-1][j-1];
                        int delete = dp [i-1][j];
                        int insert = dp [i][j-1];
                        dp[i][j] = 1+ Math.min(replace, Math.min(delete, insert));
                    }
                }
            }
           return dp[m][n];
    }
}