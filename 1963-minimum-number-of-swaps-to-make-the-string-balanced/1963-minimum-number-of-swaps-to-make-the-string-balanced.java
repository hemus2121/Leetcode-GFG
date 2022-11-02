class Solution {
    public int minSwaps(String s) {
        int open =0;
        for (int i =0;i< s.length();i++){
            char ch = s.charAt(i);
            if (ch =='['){
                open++;
            }else if (open >0 && ch == ']'){
                open --;
            }
        }
        return (open+1)/2;
    }
}