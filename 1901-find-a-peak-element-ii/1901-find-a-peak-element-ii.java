class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int startCol=0, endCol=mat[0].length-1;
        
        while (startCol <= endCol){
            
            int maxRow=0;
            // middle column
            int midCol=startCol + (endCol-startCol)/2;
            
            // we need to find MAX element in mid column identified above
            for (int row=0;row< mat.length;row++){
               maxRow = mat[row][midCol]> mat[maxRow][midCol] ? row : maxRow;   
            }
            
            
            boolean leftMax  =  (midCol-1 >= startCol) && mat[maxRow][midCol-1] > mat[maxRow][midCol];
            boolean rightMax =  (midCol+1 <= endCol) && mat[maxRow][midCol+1] > mat[maxRow][midCol];
            
            if (!leftMax && !rightMax){  // we have found the peak element
                return new int []{ maxRow, midCol};
            }else if (rightMax){
                // if rightIsBig, then there is an element in 'right' that is bigger than all the elements in the 'midCol', 
                startCol = midCol+1; //so 'midCol' cannot have a 'peakPlane'
            } else endCol= midCol-1; // leftIsBig
        }  
        return null;
    }
}