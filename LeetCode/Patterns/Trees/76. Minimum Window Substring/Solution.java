// class Solution{
//     public String minWindow(String s,String t){
//         HashMap<Character,Integer> need=new HashMap<>();
//         HashMap<Character,Integer> window=new HashMap<>();
//         int left=0;
//         for(int i=0;i<t.length();i++){
//             char ch=t.charAt(i);
//             need.put(ch,need.getOrDefault(ch,0)+1);
//         }
//         int have=0;
//         int minLen=Integer.MAX_VALUE;
//         int start=0;
//         for(int right=0;right<s.length();right++){
//             char ch=s.charAt(right);
//             window.put(ch,window.getOrDefault(ch,0)+1);
//             if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){
//                 have++;
//             }
//             while(have==need.size()){
//                 int len=right-left+1;
//                 if(len<minLen){
//                     minLen=len;
//                     start=left;
//                 }
//                 char leftChar=s.charAt(left);
//                 window.put(leftChar,window.get(leftChar)-1);
//                 if(need.containsKey(leftChar) && window.get(leftChar)<need.get(leftChar)){

//                     have--;
//                 }
//                 left++;

//             }
            

//         }
//         if(minLen==Integer.MAX_VALUE){
//             return "";
//         }
//         return s.substring(start,start+minLen);


//     }
// }



class Solution {
    public String minWindow(String s, String t) {

        int[] hash = new int[128];

        int n = s.length();
        int m = t.length();

        // Store frequency of characters in t
        for(int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;

        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int cnt = 0;

        while(r < n) {

            // Add character from right
            if(hash[s.charAt(r)] > 0) {
                cnt++;
            }

            hash[s.charAt(r)]--;

            // When all required characters are matched
            while(cnt == m) {

                // Update minimum window
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Remove character from left
                hash[s.charAt(l)]++;

                if(hash[s.charAt(l)] > 0) {
                    cnt--;
                }

                l++;
            }

            r++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}