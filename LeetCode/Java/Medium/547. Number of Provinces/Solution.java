class Solution{
    public int findCircleNum(int[][] n){
        boolean[] visited=new boolean[n.length];
        int provinces=0;
        for(int i=0;i<n.length;i++){
            if(!visited[i]){
                dfs(i,n,visited);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int city,int[][] n,boolean[] visited){
        visited[city]=true;
        for(int i=0;i<n.length;i++){
            if(n[city][i]==1 && !visited[i]){
                dfs(i,n,visited);
            }
        }
    }
}