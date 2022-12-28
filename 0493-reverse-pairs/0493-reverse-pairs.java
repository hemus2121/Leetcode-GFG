class Solution {
     int mod = (int) Math.pow (10,9)+7;
    public int reversePairs(int[] nums) {
        return merge_Sort(nums, 0, nums.length-1);
    }
    
    int merge_Sort(int [] nums, int left, int right){
          if (left==right) return 0;
            int mid = (left+right)/2;
            int x = merge_Sort(nums, left, mid);
            int y = merge_Sort(nums,mid+1,right);
            int z = merge(nums, left, mid+1, right);
            return (x+y+z)%mod;
    }
    
    int merge (int [] nums, int low, int mid, int right){
        int p1=low,p2=mid,p3=0,count=0;
       
        //count reverpair first
        while (p1<mid & p2 <=right){
             if (nums[p1] > (2*(long) nums[p2])) {
                count = count + ((mid-p1)+mod)%mod;
                p2++;
            }else{
                p1++;
            }
        }
        
         //create temp array 
        int [] temp = new int [right-low+1];
        p1=low; p2=mid;
        //normal while loop 
        while (p1<mid && p2<=right){
            if (nums[p1]<=nums[p2]){
                temp[p3++] = nums[p1++];
            }else{
                temp[p3++] = nums[p2++];
            }
        }

        //copy remaining elemets
        while (p1<mid){
            temp[p3++] = nums[p1++];
        }

        while (p2<=right){
            temp[p3++] = nums[p2++];
        }

        //copy back into original array
        for (int i=0;i<right-low+1;i++){
            nums[low+i] = temp[i];
        }
        return count%mod;
    }
}