class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        ///corner case
        if (strs.length==1) return strs[0];
        
        // get length of minimum str lenght for that compare 
        int minLen = Integer.MAX_VALUE;
        for (String s : strs){
            minLen = Math.min(minLen, s.length());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i =0;i< minLen;i++){
            char c = strs[0].charAt(i);
            for (int j = 1 ;j< strs.length;j++){
                if (c != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            // aappend to result  is there 
            sb.append(c);
        }
        return sb.toString();
    }
}