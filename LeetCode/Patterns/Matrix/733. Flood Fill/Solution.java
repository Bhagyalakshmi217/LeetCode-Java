class Solution{
    public int[][] floodFill(int[][] img,int sr,int sc,int newColour){
        int rows=img.length;
        int cols=img[0].length;
        // save the img
        int oldColour=img[sr][sc];    
        
        // edge case
        if(oldColour==newColour){
            return img;
        }
        dfs(img,sr,sc,oldColour,newColour,rows,cols);
        return img;
        
        
    }
    private void dfs(int[][] img,int r,int c,int oldColour,int newColour,int rows,int cols){
        if(r<0 || r>=rows || c<0 || c>=cols || img[r][c]!=oldColour){
            return;
        }
        img[r][c]=newColour;
        dfs(img,r-1,c,oldColour,newColour,rows,cols);
        dfs(img,r+1,c,oldColour,newColour,rows,cols);
        dfs(img,r,c-1,oldColour,newColour,rows,cols);
        dfs(img,r,c+1,oldColour,newColour,rows,cols);
    }
}