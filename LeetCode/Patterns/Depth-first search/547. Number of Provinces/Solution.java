// class Solution {

//     public void dfs(int city, int[][] n, boolean[] visited){
//             visited[city]=true;
//             for(int j=0;j<n.length;j++){
//                 if(n[city][j]==1 && !visited[j]){
//                     dfs(j,n,visited);
//                 }
//             }
//         }
//     public int findCircleNum(int[][] n){
//         boolean[] visited=new boolean[n.length];
//         int count=0;
//         for(int i=0;i<n.length;i++){
//             if(!visited[i]){
//                 count++;
//                 dfs(i,n,visited);
//             }
//         }
//         return count;
//     }
// }





    //     visited[city] = true;

    //     for(int i = 0; i < isConnected.length; i++){

    //         if(isConnected[city][i] == 1 && !visited[i]){
    //             dfs(i, isConnected, visited);
    //         }

    //     }
    // }

    // public int findCircleNum(int[][] isConnected) {

    //     int n = isConnected.length;

    //     boolean[] visited = new boolean[n];

    //     int provinces = 0;

    //     for(int i = 0; i < n; i++){

    //         if(!visited[i]){

    //             provinces++;

    //             dfs(i, isConnected, visited);

            

    //     return provinces;
    // }





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