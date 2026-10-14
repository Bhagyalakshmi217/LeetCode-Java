import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        // -1 means not colored yet
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {

            // Handle disconnected components
            if (color[start] == -1) {

                Queue<Integer> q = new LinkedList<>();

                // Give starting node color 0
                color[start] = 0;
                q.offer(start);

                while (!q.isEmpty()) {

                    int node = q.poll();

                    // Check all adjacent nodes
                    for (int neighbor : graph[node]) {

                        // If neighbor is not colored
                        if (color[neighbor] == -1) {

                            // Give opposite color
                            color[neighbor] = 1 - color[node];

                            q.offer(neighbor);
                        }

                        // If both have same color
                        else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}