import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        // Handle disconnected components
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (dfs(i, adj, visited, pathVisited)) {
                    return false;   // cycle found
                }
            }
        }

        return true;   // no cycle
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            // Neighbor never visited
            if (!visited[neighbor]) {

                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            }

            // Neighbor is in current DFS path
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        // Backtracking:
        // node is no longer in current DFS path
        pathVisited[node] = false;

        return false;
    }
}