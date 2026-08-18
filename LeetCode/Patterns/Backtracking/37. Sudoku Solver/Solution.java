class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isSafe(board,i,j,ch)){
                            board[i][j]=ch;
                            if(solve(board)){
                                return true;
                            }
                                board[i][j]='.';
                            }
                    }
                    
                    return false;
                    }
                }

            }
            return true;
        }
        private boolean isSafe(char[][] board,int row,int col,char ch){
            for(int j=0;j<board[0].length;j++){
                if(board[row][j]==ch){
                    return false;
                }
            }
            for(int i=0;i<board.length;i++){
                if(board[i][col]==ch){
                    return false;
                }
            }
            int startRow=(row/3)*3;
            int startCol=(col/3)*3;

            for(int i=startRow;i<startRow+3;i++){
                for(int j=startCol;j<startCol+3;j++){
                    if(board[i][j]==ch){
                        return false;
                    }
                }
            }
            return true;
        }
        
    }
