// import java.util.*;

// class Solution {

//     public boolean canFinish(int numCourses, int[][] prerequisites) {

//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Build graph
//         for (int[] edge : prerequisites) {
//             int course = edge[0];
//             int prerequisite = edge[1];

//             adj.get(prerequisite).add(course);
//         }

//         boolean[] visited = new boolean[numCourses];
//         boolean[] pathVisited = new boolean[numCourses];

//         // Handle disconnected components
//         for (int i = 0; i < numCourses; i++) {

//             if (!visited[i]) {

//                 if (dfs(i, adj, visited, pathVisited)) {
//                     return false;   // cycle found
//                 }
//             }
//         }

//         return true;   // no cycle
//     }

//     private boolean dfs(int node,
//                         ArrayList<ArrayList<Integer>> adj,
//                         boolean[] visited,
//                         boolean[] pathVisited) {

//         visited[node] = true;
//         pathVisited[node] = true;

//         for (int neighbor : adj.get(node)) {

//             // Neighbor never visited
//             if (!visited[neighbor]) {

//                 if (dfs(neighbor, adj, visited, pathVisited)) {
//                     return true;
//                 }
//             }

//             // Neighbor is in current DFS path
//             else if (pathVisited[neighbor]) {
//                 return true;
//             }
//         }

//         // Backtracking:
//         // node is no longer in current DFS path
//         pathVisited[node] = false;

//         return false;
//     }
// }

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Create graph and calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            // prerequisite -> course
            adj.get(prerequisite).add(course);

            // course has one more prerequisite
            indegree[course]++;
        }

        // Put courses with no prerequisites into queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // BFS
        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            // Visit all courses depending on this course
            for (int nei : adj.get(node)) {

                indegree[nei]--;

                // All prerequisites completed
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // If all courses are processed, no cycle
        if(count == numCourses){
            return true;
        }
        return false;
    }
}