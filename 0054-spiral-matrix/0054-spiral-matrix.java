class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int startRow =0;
        int endRow = matrix.length-1;
        int startCol=0;
        int endCol = matrix[0].length-1;
        
        while (startRow <= endRow && startCol <= endCol){
            
            //1st row 
            for(int i = startCol;i<=endCol;i++){
                res.add(matrix[startRow][i]);
            }
            startRow ++;
            
             //last column
            for (int i = startRow;i<= endRow;i++){
                res.add(matrix[i][endCol]);
            }
            endCol--;
            
            //last row
            if (startRow <= endRow){
                 for (int i =endCol;i>=startCol;i--){
                   res.add(matrix[endRow][i]);
                }
            }
            endRow--;
            
            //1st column
             if (startCol<=endCol){
                 for (int i= endRow ; i >= startRow;i-- ){
                     res.add(matrix[i][startCol]);
                 }
             }
            startCol++;  
        }
        return res;
    }
}