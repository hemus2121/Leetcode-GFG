class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList();
        List<Integer> row = null, previous =null;
        
        //Iterate till row count given
        for (int i =0;i< numRows;++i){
            row = new ArrayList<>();
            for (int j =0;j<=i;++j){
                if (j==0 || j==i) //1st column or last column
                    row.add(1);
                else 
                    row.add(previous.get(j-1)+ previous.get(j));
             }
                previous = row;
                resultList.add(row);
        }
        return resultList;
        
    }
}