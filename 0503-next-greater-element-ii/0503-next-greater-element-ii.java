class Solution {
    public int[] nextGreaterElements(int[] nums) {
         int n = nums.length;
         int [] nge = new int [n];
         Stack<Integer> st = new Stack();
        
        // iterate for elements in input array from RIGHT side
        //size is 2n since we r thinkng of copying same array elements to as it is on right side
        for (int i = 2 * n - 1; i >= 0; i--) {
            //check for any less element in stack and remove them 
            while (!st.isEmpty() && st.peek() <= nums[i % n]){
                st.pop(); 
            }
            if (i <n){ /// since we need for only 1st half
              if (!st.isEmpty()){
                  nge[i]= st.peek();
              }  
              else nge[i] = -1;  
            } 
            st.push(nums[i%n]);
        }
        return nge;
        
    }
}