class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character,Integer> countMap = new HashMap<>();
        //iterate each character
        for (char c: s.toCharArray()){
            if (countMap.containsKey(c)){
                int value = countMap.get(c);
                value++;
                countMap.put(c, value);
            }else {
                countMap.put(c, 1);
            }
        }
        
        for (int i =0;i< s.length();i++){
            if (countMap.get(s.charAt(i))==1) return i;
        }
        return  -1;
        
    }
}