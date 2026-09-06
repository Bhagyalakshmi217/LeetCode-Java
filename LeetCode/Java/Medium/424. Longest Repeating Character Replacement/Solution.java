class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxFreq=0;
        int maxLen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));
            
            while(right-left+1-maxFreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
        
    }
}