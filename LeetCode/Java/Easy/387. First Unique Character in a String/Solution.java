// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(map.get(ch)==1){
//                 return i;
//             }
//         }
//         return -1;
        
//     }
// }




class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
