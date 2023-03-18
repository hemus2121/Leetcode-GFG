class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> resultList = new ArrayList();
        computeCombSum(1,k, n, new ArrayList<>(), resultList);
        return resultList;
    }
    
    void computeCombSum(int start, int k , int target, List <Integer> ds, List<List<Integer>> result){
        //base case
        if (target==0){
            if (ds.size()==k){ // required number of elements matched required elements count
                result.add(new ArrayList<Integer>(ds));
                return;
            }
        }
        
       for(int i=start;i<= 9;i++){  //number start from 1 as given
           ds.add(i);
           computeCombSum(i+1,k, target-i,ds, result);
           ds.remove(ds.size()-1);
       }
    }
}