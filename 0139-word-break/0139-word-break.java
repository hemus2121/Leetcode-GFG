class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int [] lookup = new int [ s.length()+1];
        Arrays.fill(lookup, -1);
        return checkWordBreak(wordDict, s, lookup);
         
    }
    boolean checkWordBreak(List<String> wordDict, String s, int [] lookup){
         // `n` stores length of the current substring
        int n =  s.length();
          // return true if the end of the string is reached
        if (n==0) return true;
        
        if (lookup[n] == -1){
            // mark subproblem as seen (0 initially assuming string can't be segmented)
            lookup[n] =0;
            for (int i =1;i<= n ;i++){
                 // consider all prefixes of the current string
                String prefix = s.substring(0, i);
                // if prefix is found in dictionary , then recur for the suffix
                if (wordDict.contains(prefix) && checkWordBreak(wordDict, s.substring(i), lookup)){
                    lookup[n] = 1;
                    return true;
                }
            }
            
        }
        return lookup[n]==1;
    }
}