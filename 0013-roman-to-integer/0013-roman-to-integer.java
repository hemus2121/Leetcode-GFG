class Solution {
    
    static Map <Character, Integer> romMap  = new HashMap<>();
        static {
            romMap.put('I', 1);
            romMap.put ('V', 5);
            romMap.put ('X', 10);
            romMap.put ('L', 50);
            romMap.put ('C', 100);
            romMap.put ('D', 500);
            romMap.put ('M', 1000);
        }
    public int romanToInt(String s) {
        int res =0;
        
        for (int i =0;i< s.length()-1;i++){
            if (romMap.get(s.charAt(i)) < romMap.get(s.charAt(i+1))){
                res = res - romMap.get(s.charAt(i));
            }else res = res + romMap.get(s.charAt(i));
        }
        return  res + romMap.get(s.charAt(s.length() - 1));
    }
}