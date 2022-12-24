class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int [] res = new int [nums.length];
        int pos=0;
        int neg=1;
        int index=0;
        while (index < nums.length){
            if (nums[index]>0){
                res[pos] = nums[index];
                pos +=2;
            }else{
                res[neg] = nums[index];
                neg +=2;
            }
            index++;
        }
        return res;
    }
}