class Solution{
    public String minWindow(String s,String t){
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        int left=0;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int have=0;
        int minLen=Integer.MAX_VALUE;
        int start=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){
                have++;
            }
            while(have==need.size()){
                int len=right-left+1;
                if(len<minLen){
                    minLen=len;
                    start=left;
                }
                char leftChar=s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(need.containsKey(leftChar) && window.get(leftChar)<need.get(leftChar)){

                    have--;
                }
                left++;

            }
            

        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLen);


    }
}