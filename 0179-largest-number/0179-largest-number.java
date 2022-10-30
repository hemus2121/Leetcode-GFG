class Solution {
    public String largestNumber(int[] nums) {
        //coverr to string array
        String [] stArray = new String [nums.length] ;
        int in =0;
        for(int i : nums){
            stArray [in++]= String.valueOf(i);
        }
         //Sort the array based on comparator
        Arrays.sort(stArray, (s1,s2) ->(s2+s1).compareTo(s1+s2));
        
       if (stArray[0].equals("0")) {
            return "0";
        }
        
       
        
        StringBuilder sb = new StringBuilder();
        for (String s : stArray){
            sb.append(s);
        }
        return sb.toString();
        
        
        
    }
}