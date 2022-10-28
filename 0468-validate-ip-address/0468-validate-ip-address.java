class Solution {
    public String validIPAddress(String queryIP) {
         if (queryIP.chars().filter(ch -> ch =='.').count()==3)
            return validateV4(queryIP);
         else if (queryIP.chars().filter(ch -> ch ==':').count()==7)
             return validatev6(queryIP);
         else return "Neither";
    }
    
    String validateV4(String ip){
        String[] data = ip.split("\\.", -1);   
        for (String s : data){
           // Validate integer in range (0, 255):
        // 1. length of chunk is between 1 and 3
            if (s.length() == 0 || s.length() > 3) return "Neither";
      // 2. no extra leading zeros
            if (s.charAt(0) == '0' && s.length() != 1) return "Neither";
      // 3. only digits are allowed
            for (char ch : s.toCharArray()) {
                if (! Character.isDigit(ch)) return "Neither";
            }
      // 4. less than 255
            if (Integer.parseInt(s) > 255) return "Neither";
        }
            return "IPv4";
    }
    
    String validatev6(String ip){
        String [] data = ip.split(":", -1);
        String allowedHex = "0123456789abcdefABCDEF";
        for (String s: data){
               // 1. at least one and not more than 4 hexdigits in one chunk
            if (s.length()==0 || s.length() >4) return "Neither";
               // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (char c : s.toCharArray()){
                if (allowedHex.indexOf(c) ==-1) return "Neither";
            }
        }
        return "IPv6";
    }
}