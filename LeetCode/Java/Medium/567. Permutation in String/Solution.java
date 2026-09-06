class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        int left=0;
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            freq1[ch1-'a']++;
        }
        for(int right=0;right<s2.length();right++){
            char ch2=s2.charAt(right);
            freq2[ch2-'a']++;
            while(right-left+1>s1.length()){
                char leftChar=s2.charAt(left);
                freq2[leftChar-'a']--;
                left++;
            }
        
        if(Arrays.equals(freq1,freq2)){
            return true;
        }
        }
        return false;
        
        
    }
}