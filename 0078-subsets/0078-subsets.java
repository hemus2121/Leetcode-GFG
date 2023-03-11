class Solution {
     List <List<Integer>> finalList = new ArrayList();

    public List<List<Integer>> subsets(int[] A) {
          // since values are needed in lexo order
       
        int n = A.length;
        List<Integer> dataList1 = new ArrayList<>();
        
        //iterate for 2 to power n
        for (int num=0; num< (1<<n); num++){ 
             List<Integer> dataList = new ArrayList<>();
            for (int i=0;i< n;i++){
                //check if the ith bit is set or not
                if ((num & (1<<i)) !=0){
                    dataList.add(A[i]);
                }
            }
            finalList.add(dataList);
        }
        return finalList;
    }
     /*public void computeSubSets(int index, ArrayList <Integer> A, ArrayList <Integer> tempList ){
        
        finalList.add(new ArrayList(tempList));
          
        for (int i =index;i<A.size();i++){
            //DO - Add element to tempList
            tempList.add(A.get(i));
            //Recursive Call
            computeSubSets(i+1, A, tempList);
            
            // UNDO - remove the added element 
            tempList.remove(tempList.size()-1);
        }
    }*/
}