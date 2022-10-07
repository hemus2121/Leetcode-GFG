class Solution {
    public int removeDuplicates(int[] nums) {
        
        //solve using 2 pointers 
        // - i moves slowly and tells where to insert new character
        // -- j moves and check for new incoming character
        int i =0;
        for (int j =1;j< nums.length;j++){
            // if new number has come put that in updated ith position
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;// return location which is unique elements are copied
    }
}