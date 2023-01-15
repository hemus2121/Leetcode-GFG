class Solution {
    public String largestOddNumber(String num) {
        //lets iterate from right 
        
        for (int i = num.length()-1;i >=0;i--){
            int n = num.charAt(i) -'0';
            //System.out.println(n);
            
            if (n%2==1){
                return num.substring(0, i+1);
            }
        }
        return "";
        
    }
}