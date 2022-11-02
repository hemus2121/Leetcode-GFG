class Solution {
    public int compress(char[] chars) {
        int ans = 0, len =0;
        while (len < chars.length){
            char c = chars[len];
            int count =0;
            //get duplicate characters
            while (len <chars.length && chars[len]==c){
                len++;
                count++;
            }
            chars[ans++]=c; // store incoming character
            
            //need to append count
            if (count !=1){
                for (char cc : Integer.toString(count).toCharArray()){
                    chars[ans++] = cc;
                }
            }
        }
        return ans;
    }
}