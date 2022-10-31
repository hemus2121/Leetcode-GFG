class Solution {
    public String tictactoe(int[][] moves) {
        // using 2d matrix properties
        int n =3;
        int [] rows = new int [n];
        int [] cols = new int [n];
        int diag=0, anti_diag=0;
        
        // Two players having value of 1 and -1, player_1 with value = 1 places first.
        int player = 1;
        
        for( int [] move : moves){
             int row = move[0];
             int col = move[1];
            //upate row and col vlaues
            rows [row] += player;
            cols [col] += player;
            
             // If this move is placed on diagonal or anti-diagonal, 
            // we shall update the relative value as well.
            if (row ==col) diag+= player;
            if (row + col == (n-1)) anti_diag+= player;
            
            //check conditions
            if (Math.abs(rows[row])==n || Math.abs(cols[col])==n 
               || Math.abs(diag)==n || Math.abs(anti_diag)==n)
                return player ==1 ? "A":"B";
            
            //If player 1 has not won change to player B
            player *=-1;
        }
        return moves.length == n*n ? "Draw": "Pending";
        
    }
}