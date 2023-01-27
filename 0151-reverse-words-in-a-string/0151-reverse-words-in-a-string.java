class Solution {
    public String reverseWords(String s) {
        
        if (s == null) return "";
        int n = s.length();
        char [] a = s.toCharArray();
        
        //1. reverse complete sentence
        reverse (a, 0, n-1);
        
        //2. reverse each word
        reverseWords(a, n);
        
        //3. trim spaces
        return cleanup(a, n);
    }
    void reverse(char [] a, int start, int end){
        while (start < end){
                char t = a[start];
                a[start] = a[end];
                a[end] = t;
                start++;
                end--;
        }
    }
    
    void reverseWords(char [] a, int n){
       int i =0, j=0;
        while (i <n){
            while (i<j || i <n && a[i] == ' ') // skip starting spaces
                i++;
            while (j<i || j <n && a[j] != ' ') // skip non spaces
                j++;
            reverse (a,i, j-1); // reverse each words
        }
    }
    
    String cleanup(char [] a, int n){
        int i =0, j=0;
        while (j <n ){
            while (j<n && a[j] == ' ')//skip spaces
                j++;
            while (j<n && a[j] != ' ')   // valid charaters so copy data
                a[i++] = a[j++];
            while (j<n && a[j] == ' ')//skip spaces
                j++;
            
            if ( j<n ) //keep only 1 space
                a[i++]= ' ';
        }
        return new String (a).substring(0,i);
    }
}