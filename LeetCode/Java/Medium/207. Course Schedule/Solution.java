class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList());
        }
        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){

        if(!visited[i]){
            if(!dfs(i,graph,visited,pathVisited)){
                return false;
            }
        }
        }

        return true;
    }
    private boolean dfs(int course,
                        List<List<Integer>> graph,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[course] = true;
        pathVisited[course] = true;
        for (int next : graph.get(course)) {
            if (!visited[next]) {

                if (!dfs(next, graph, visited, pathVisited)) {
                    return false;
                }
            }
            else if (pathVisited[next]) {
                return false;
            }
        }
        pathVisited[course] = false;

        return true;
    }

}