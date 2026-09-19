import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

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
        int index = 0;
        int[] order=new int[numCourses];

        while (!q.isEmpty()) {

            int node = q.poll();

            order[index++]=node;

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
        if(index!=numCourses){
            return new int[0];
        }
        return order;
    }
}