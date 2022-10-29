class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length();
          //corner case
        if (n== k ) return "0";
        
        Stack<Character> st = new Stack();
        
        for (char c : num.toCharArray()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while ( k >0 && !st.isEmpty() && st.peek() > c){
                st.pop();
                k--;
            }
            //add incoming element
            st.push(c);
        }
        
        //for corner case like "1111"
        while (k >0){
            st.pop();
            k--;
        }
        
        //Result building stuff from stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        
        //removing 0 at MSB
        while (sb.length() >1 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        
        return sb.reverse().toString();
        
        
        
    }
}