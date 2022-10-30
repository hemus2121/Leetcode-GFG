 class Pair{ 
        char c;
        int count;
     
        Pair (char cc, int count){
         this.c=cc;
         this.count = count;
        }
    }
class Solution {
   
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> st = new Stack<>();
        
        int n = s.length();
        char [] c = s.toCharArray();
        for (int i =0;i< n ;i++){
            //check if elements is pesent at top of stack - if not add with count 1
            if (st.empty() || st.peek().c != c[i]){
                st.push(new Pair(c[i], 1));
            }else {
                //increment count prenset in stack and check required count
                if (++st.peek().count == k){
                    st.pop();
                }
            }
        }
        
        // take out from stack and build response 
        StringBuilder sb = new StringBuilder();
        while (!st.empty()){
            Pair  p = st.pop();
            for (int i =0;i< p.count;i++){
                sb.append (p.c);
            }
        }
        return sb.reverse().toString();
        
    }
}