class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int left=0;
        int[] freqP=new int[26];
        int[] freqS=new int[26];
        for(int i=0;i<p.length();i++){
            freqP[p.charAt(i)-'a']++;
        }
        for(int right=0;right<s.length();right++){
            freqS[s.charAt(right)-'a']++;
            if(right-left+1>p.length()){
                freqS[s.charAt(left)-'a']--;
                left++;
            }
        
            if(Arrays.equals(freqP,freqS)){
                result.add(left);
            }
        }

        
        return result;
        
    }
}