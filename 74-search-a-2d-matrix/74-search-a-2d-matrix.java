class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length ==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n*m)-1;
        while (low<= high){
            int mid = (low + high) /2;
            //get 2D matrix co ordinates
            int row = mid/m, col = mid%m;
            if (matrix[row][col]== target) return true;
            if (matrix[row][col] < target) low = mid+1;
            else high = mid-1;
        }
        return false;        
    }
}