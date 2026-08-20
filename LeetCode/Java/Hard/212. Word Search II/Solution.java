class TrieNode{
    TrieNode[] children=new TrieNode[26];
    String word;
}
class Solution {
    TrieNode root=new TrieNode();
    List<String> ans=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int rows=board.length;
        int cols=board[0].length;
        for(String word:words){
            insert(word);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(board,i,j,root);
            }
        }
        return ans;
    }
    private void insert(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';

            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.word=word;
        }

        private void dfs(char[][] board,int r,int c,TrieNode node){
            if(r<0 || r>=board.length ||c<0 ||c>=board[0].length){
                return;
            }
            char ch=board[r][c];

            if(ch=='#' || node.children[ch-'a']==null){
                return;
            }
            node=node.children[ch-'a'];

            if(node.word!=null){
                ans.add(node.word);
                node.word=null;
            }

            board[r][c]='#';
            dfs(board,r+1,c,node);
            dfs(board,r-1,c,node);
            dfs(board,r,c-1,node);
            dfs(board,r,c+1,node);

            board[r][c]=ch;
        }




        
    }
