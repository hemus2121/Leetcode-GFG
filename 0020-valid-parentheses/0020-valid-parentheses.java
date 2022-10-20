class Solution {
    public boolean isValid(String s) {
     Stack<Character> st = new Stack<>();
        for (int i =0;i< s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else {
                if (st.isEmpty())return  false;
                //check with top of stack and respective incoming character
                char c = st.pop();
                if( ( c == '(' && s.charAt(i)== ')') ||
                        ( c == '{' && s.charAt(i)== '}') ||
                        ( c == '[' && s.charAt(i)== ']') )
                    continue;
                return  false;
            }
        }
        return  (st.isEmpty())? true: false;
    }
}