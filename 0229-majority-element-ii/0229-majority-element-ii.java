class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // for N/3 element we need 2 variable and 2 counters
        int num1=-1, num2=-1, count1=0, count2=0, len = nums.length;
        
        //iterate array elemements
        for (int num: nums){
            if (num == num1) count1++;
            else if (num == num2) count2++;
            else if (count1 == 0){
                num1 = num;
                count1++;
            } else if (count2 == 0){
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        //need to cross check to make sure we have correct majority element
        List<Integer> resList = new ArrayList();
        count1=0;
        count2=0;
    
        for (int a: nums){
            if (a == num1) count1++;
            else if(a == num2) count2++;
        }
        
        if (count1 > len/3) resList.add(num1);
        if (count2 > len/3) resList.add(num2);
        
        return resList;
        
    }
}