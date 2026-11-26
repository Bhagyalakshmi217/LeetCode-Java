class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int[] freqp=new int[26];
        int[] freqs=new int[26];
        int left=0;
        for(int i=0;i<p.length();i++){
            freqp[p.charAt(i)-'a']++;
        }
        for(int right=0;right<s.length();right++){
            freqs[s.charAt(right)-'a']++;
            while(right-left+1>p.length()){
                freqs[s.charAt(left)-'a']--;
                left++;
            }
            if(Arrays.equals(freqs,freqp)){
                result.add(left);
            }
        }
            return result;
        
        
    }
}