class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int level=0;
        while(!q.isEmpty()){
            level++;
        
            int size=q.size();
            for(int k=0;k<size;k++){
                String word=q.poll();
        
                char[] arr=word.toCharArray();
        
                for(int i=0;i<arr.length;i++){
                    char original=arr[i];
        
                    for(char ch='a';ch<='z';ch++){
                        if(ch==original){
                        continue;
                        }
            
            arr[i]=ch;
    
            String newWord=new String(arr);
            if(newWord.equals(endWord)){
                return level+1;
            }
            if(set.contains(newWord)){
                q.offer(newWord);
                set.remove(newWord);
            }
                    }
            arr[i]=original;
        }
        }
    }
        return 0;
        
    }
}