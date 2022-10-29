class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
     String build(String s){
         Stack<Character> st = new Stack();
         StringBuilder sb = new StringBuilder();
         for (char c : s.toCharArray()){
             if (c != '#'){
                 st.push(c);
             }else if (!st.isEmpty()){
                 st.pop();
             }
         }
         while (!st.isEmpty()){
             sb.append(st.pop());
         }
         return sb.toString();
     }
}