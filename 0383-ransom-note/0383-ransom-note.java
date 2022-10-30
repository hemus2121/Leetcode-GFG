class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        // check if required  is greater than input data length
        if (ransomNote.length() > magazine.length()) return false;
        
        // put everything in magzine count into map
        Map <Character, Integer> countMap = new HashMap();
        for (char c : magazine.toCharArray()){
            countMap.put (c, countMap.getOrDefault(c, 0)+1);
        }
        
        // iterate over ransomNote and check if count of character reduces to 0
        for (char c : ransomNote.toCharArray()){
            int value = countMap.getOrDefault(c,0);
            if (value ==0) return false;
            /// Reduce and put updated cout
            countMap.put(c, value-1);
        }
        // no false returned so far
        return true;
        
        
    }
}