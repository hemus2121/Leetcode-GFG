class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque <Integer> dq = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();

        // slide for 1st window of size B
        for (int i =0;i< k;i++){
            // keep of removing smaller elements
            while ( !dq.isEmpty() && dq.getLast()< nums[i]){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        // push the result from front of Q to ans
        resList.add(dq.getFirst());

        for (int i = k;i< nums.length;i++){
            while ( !dq.isEmpty() && dq.getLast()< nums[i]){
                dq.removeLast();
            }
            dq.addLast(nums[i]);

            //   remove if outgoing element (i-k) element is same as 1st element in deque
            if (dq.getFirst()==nums[i-k] ){
                dq.removeFirst();
            }
            resList.add(dq.getFirst());
        }
        return resList.parallelStream().mapToInt(val->val).toArray();
        
    }
}