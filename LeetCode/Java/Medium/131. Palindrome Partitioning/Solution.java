class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return ans;
        
    }
    private void dfs(String s,int index,List<String> path){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int end=index;end<s.length();end++){
            String sub=s.substring(index,end+1);
            if(isPalindrome(sub)){
                path.add(sub);
                dfs(s,end+1,path);
        
        
        path.remove(path.size()-1);
            }
        }

    }
    private boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}