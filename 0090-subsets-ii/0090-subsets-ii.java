class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getSubSets(0, nums,result, new ArrayList<>());
        return result;
    }
    
    void getSubSets(int ind, int [] nums, List<List<Integer>> result, List<Integer> ds ){
        //base case
        result.add(new ArrayList<>(ds));
        
        //iterate for all elements present in array
        for (int i =ind;i< nums.length;i++){
        if (i != ind && nums[i] == nums[i - 1]) continue; // skip duplicates since they re next to each other
            ds.add(nums[i]);
            getSubSets(i+1, nums, result, ds);
            ds.remove(ds.size()-1);
        }
    }
}