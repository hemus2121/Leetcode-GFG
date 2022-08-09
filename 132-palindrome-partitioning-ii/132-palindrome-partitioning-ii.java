class Solution {
    public int minCut(String s) {
        int n = s.length();
        int min=0;
        
       //isPalin[i][j] represents String i to j is a palindrome or not
        boolean [][] isPalin = new boolean[n][n];
        
         //dpArray[i] represents minimum number of cuts from String 0 to i
        int [] dpArray = new int [n];
        
        // iterate entire string
        for (int i=0;i<n;i++) {  //column traversal
            min = i; // Max number of cuts is i for string length i+1
            
            // iterate until ith index-to do palindromic check 
            for (int j =0;j<=i;j++) {  // row traversal
                
               // Why i - j < 3  ?
            // 1. String length=1 is always palindrome so no need to check in boolean table
            // 2. String length=2 is palindrome if Ci == Cj which is already checked in first part so no need to check again
            // 3. String length =3 is palindrome if Ci == Cj which is already checked in first part and Ci+1 and Cj-1 is same character which is always a palindrome
            
            // If String length >=4
            // then check if Ci == Cj and if they are equal check if String[j+1 .. i-1] is a palindrome from the boolean table
                if (s.charAt(i)== s.charAt(j) && ( i-j < 3  || isPalin[j+1][i-1])){
                    //palindrome as Ci == Cj and String[j+1...i-1] is a palindrome
                    isPalin[j][i]= true;
                    
                    //j == 0 because String from j to i is a palindrome and it starts from first character so means no cuts needed Else need a cut at jth location and it will be cuts encountered till j-1 + 1
                    min =j==0?0: Math.min(min, dpArray[j-1]+1);
                }
            }
            dpArray[i] =min;
        }
        return dpArray[n-1];
    }
}