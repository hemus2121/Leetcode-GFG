class Solution {
    int [] [] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int [m+1][n+1];
        return computeLongestRecur(text1, text2,m, n);
    }
    
    int computeLongestRecur(String text1,String text2, int m, int n){
       // base case 
        if (m==0 || n==0){
            return 0;
        }
        //check if already found
        if (dp[m][n]!= 0 ) return dp [m][n];
        
        //else compute
        if (text1.charAt(m-1) == text2.charAt(n-1)){
            dp[m][n] = 1+ computeLongestRecur(text1, text2, m-1, n-1);
        }else {
            int sub1 = computeLongestRecur(text1,text2, m-1,n);
            int sub2 = computeLongestRecur(text1,text2, m,n-1);
            dp [m][n] = Math.max(sub1, sub2);
        }
        return dp[m][n]; 
    }
}