class Solution {
    public boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        
        int index=0;
        for (int row=0;row< rowLen;row++){
            for (int col=0;col < colLen;col++){
                if (board[row][col] == word.charAt(index)){
                    if (searchNext(board, word, row, col, index,rowLen, colLen))
                        return true;
                }
            }
        }
        return false;
    }
    
    boolean searchNext(char [][]board, String word, int row, int col, int index, int rowLen, int colLen){
         // if index reaches at the end that means we have found the word
        if (index == word.length()){
            return true;
        }
        
        //check boundary condition
        if (row <0 || row >= rowLen || col <0 || col >= colLen || board[row][col] == '!' || board[row][col] != word.charAt(index))
            return false;
        
         // this is to prevent reusing of the same character
        char c = board[row][col];
        board[row][col] = '!';
        
        //check for 4 directions 
        boolean top = searchNext(board, word, row -1, col, index+1, rowLen, colLen);
        boolean bottom = searchNext(board, word, row +1, col, index+1, rowLen, colLen);
        boolean left = searchNext(board, word, row, col-1, index+1, rowLen, colLen);
        boolean right = searchNext(board, word, row, col+1, index+1, rowLen, colLen);
        
        board[row][col] = c; // undo change
        
        return top || bottom || left|| right;
    }
}