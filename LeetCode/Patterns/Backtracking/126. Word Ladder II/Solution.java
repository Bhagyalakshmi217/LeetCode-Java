import java.util.*;

class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return ans;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        set.remove(beginWord);

        // Stores child -> its possible parents
        Map<String, List<String>> parents = new HashMap<>();

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            // Words discovered in this BFS level
            HashSet<String> usedThisLevel = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String word = q.poll();

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        arr[i] = ch;

                        String newWord = new String(arr);

                        if (set.contains(newWord)) {

                            // Add to queue only once in this level
                            if (!usedThisLevel.contains(newWord)) {
                                q.offer(newWord);
                                usedThisLevel.add(newWord);
                            }

                            // Store parent
                            parents
                                .computeIfAbsent(newWord,
                                        x -> new ArrayList<>())
                                .add(word);

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[i] = original;
                }
            }

            // Remove after completing the whole level
            for (String word : usedThisLevel) {
                set.remove(word);
            }
        }

        // No transformation possible
        if (!found) {
            return ans;
        }

        // Backtracking
        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(
                endWord,
                beginWord,
                parents,
                path,
                ans
        );

        return ans;
    }

    private void backtrack(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> ans) {

        // Reached beginning
        if (word.equals(beginWord)) {

            List<String> currentPath = new ArrayList<>(path);

            // Currently end -> begin
            // Convert to begin -> end
            Collections.reverse(currentPath);

            ans.add(currentPath);

            return;
        }

        // Try every possible parent
        for (String parent : parents.get(word)) {

            path.add(parent);

            backtrack(
                    parent,
                    beginWord,
                    parents,
                    path,
                    ans
            );

            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}