class Solution {
    public int majorityElement(int[] nums) {
        
        //using boyee moore majorty counting algo
        int count=0, element =0;
        
        for (int num: nums){
            if (count==0){
                element = num;
            }
            if (num == element)count++;
            else count--;
        }
        return element;

    }
}