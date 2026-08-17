class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        boolean[] used=new boolean[26];
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char current=s.charAt(i);
            count[current-'a']--;
            if(used[current-'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>current && count[stack.peek()-'a']>0){
                char top=stack.pop();                
                used[top-'a']=false;
            }
            
            stack.push(current);
            used[current-'a']=true;
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.removeLast());
        }
        return result.toString();

        
    }
}