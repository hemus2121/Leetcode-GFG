class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //Using sliding window concept and set
        Set <Character>st = new HashSet<>();
        int l =0, r=0;
        int ans = 0;
        int n = s.length();
        
        //edge case
        if (n==1) return 1;
        
        while (r<n){
           //new character incoming is already present then shrink window
            if (st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }else {
                //add new incoming character to set
                st.add(s.charAt(r));
                r++;
                // compute answer till no w
                ans = Math.max(ans, st.size());
            }
        }
        return ans;        
    }
}