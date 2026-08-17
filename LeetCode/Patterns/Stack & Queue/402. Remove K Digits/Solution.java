class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<num.length();i++){
            char currDigit=num.charAt(i);
            while(!stack.isEmpty() && k>0 && stack.peek()>currDigit){
                stack.pop();
                k--;
            }
            stack.push(currDigit);
        }
            while(k>0){
                stack.pop();
                k--;
            }
        
            StringBuilder result=new StringBuilder();
            while(!stack.isEmpty()){
                result.append(stack.removeLast());
            }

            int index=0;
            while(index<result.length() && result.charAt(index)=='0'){
                index++;
            }
            result=new StringBuilder(result.substring(index));
            if(result.length()==0){
                return "0";
            }
            return result.toString();
            
        
        
        
    }
}