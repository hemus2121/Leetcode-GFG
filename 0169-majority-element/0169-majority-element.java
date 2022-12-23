class Solution {
    public int majorityElement(int[] nums) {
        
        //using boyee moore majorty counting algo
        /* int count=0, element =0;
        
        for (int num: nums){
            if (count==0){
                element = num;
            }
            if (num == element)count++;
            else count--;
        }
        return element; */
        
        // Solution - 2  using longer way
         int probCandidateindex=0, count=1;
        for (int j = probCandidateindex+1; j<nums.length;j++){
            if (nums[j]==nums[probCandidateindex]){
                count++;
            }else count--;
            
            if (count ==0){
                probCandidateindex=j;
                count=1;
            }
        }
    
    //find whehter its correct one
     int ncount=0;
     for (int num: nums) {
         if (num == nums[probCandidateindex]) 
           ncount++;
     }
     return  (ncount <= nums.length/2) ?  -1:nums[probCandidateindex];

    }
}