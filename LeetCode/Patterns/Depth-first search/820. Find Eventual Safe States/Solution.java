// class Solution {
//     private boolean dfsCheck(int node,int[][] graph,int[] vis,int[] pathVis,int[] check) {
//         vis[node]=1;
//         pathVis[node]=1;
//         check[node]=0;
//         for(int nei:graph[node]){
//             if(vis[nei]==0){
//                 if(dfsCheck(nei,graph,vis,pathVis,check)){
//                     return true;
//                 }
//             }
//                 else if(pathVis[nei]==1){
//                     return true;
//                 }
//             }
//             check[node]=1;
//             pathVis[node]=0;
//             return false;
//         }
                            
//     public List<Integer> eventualSafeNodes(int[][] graph){
//         int v=graph.length;
//             int vis[]=new int[v];
//             int pathVis[]=new int[v];
//             int check[]=new int[v];
//             for(int i=0;i<v;i++){
//                 if(vis[i]==0){
//                     dfsCheck(i,graph,vis,pathVis,check);
//                 }
//             }
//             List<Integer> safeNodes=new ArrayList<>();
//             for(int i=0;i<v;i++){
//                 if(check[i]==1){
//                     safeNodes.add(i);
//                 }
//             }
//                 return safeNodes;
            
//         }
    
// }

class Solution{
    public List<Integer> eventualSafeNodes(int[][] graph){
        int v=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        // rev the graph
        List<List<Integer>> adjRev=new ArrayList<>();
        for(int node=0;node<v;node++){
            adj.add(new ArrayList<>());
        }
        for(int node=0;node<v;node++){
            adjRev.add(new ArrayList<>());
        }
        int indegree[]=new int[v];

        // build rev graph
        for(int node=0;node<v;node++){
            for(int nei:graph[node]){
                adjRev.get(nei).add(node);
                indegree[node]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safeNodes=new ArrayList<>();

        // terminal nodes have indegree 0 with rev graph
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        // kah's bfs
        while(!q.isEmpty()){
            int node=q.poll();
            safeNodes.add(node);
            for(int nei:adjRev.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
                }
            }
            Collections.sort(safeNodes);
            return safeNodes;
        }

    }

