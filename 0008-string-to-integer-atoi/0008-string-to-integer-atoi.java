class Solution {
    public int myAtoi(String s) {
        
        if (s.isEmpty()) return 0;
        int sign =1 , base=0, n = s.length(),i=0;
        
    
        
        while (i < n && s.charAt(i) == ' ' ) ++ i;
         if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-' )) {
            sign = (s. charAt(i++) == '+' ) ? 1 : - 1 ;
        }
        
        // iterate over the characters
            while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
              if (base > Integer.MAX_VALUE /10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7))  
                return (sign == 1 ) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            base = base *10 + (s. charAt(i++) - '0' );
        }
        return base * sign;
        
    }
}