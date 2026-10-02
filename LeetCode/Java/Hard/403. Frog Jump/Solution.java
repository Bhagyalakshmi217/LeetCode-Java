import java.util.*;

class Solution {

    Map<Integer, Set<Integer>> memo = new HashMap<>();
    Map<Integer, Integer> stoneIndex = new HashMap<>();
    int[] stones;

    public boolean canCross(int[] stones) {

        this.stones = stones;

        // Store each stone position
        for (int i = 0; i < stones.length; i++) {
            stoneIndex.put(stones[i], i);
        }

        // First jump must be 1
        return dfs(0, 0);
    }

    private boolean dfs(int index, int lastJump) {

        // Reached the last stone
        if (index == stones.length - 1) {
            return true;
        }

        // Already know that this state fails
        if (memo.containsKey(index) &&
            memo.get(index).contains(lastJump)) {
            return false;
        }

        // Try lastJump - 1, lastJump, lastJump + 1
        for (int nextJump = lastJump - 1;
             nextJump <= lastJump + 1;
             nextJump++) {

            // Jump cannot be 0 or negative
            if (nextJump <= 0) {
                continue;
            }

            int nextPosition = stones[index] + nextJump;

            // Check whether a stone exists there
            if (stoneIndex.containsKey(nextPosition)) {

                int nextIndex = stoneIndex.get(nextPosition);

                if (dfs(nextIndex, nextJump)) {
                    return true;
                }
            }
        }

        // This state cannot reach the end
        memo.putIfAbsent(index, new HashSet<>());
        memo.get(index).add(lastJump);

        return false;
    }
}