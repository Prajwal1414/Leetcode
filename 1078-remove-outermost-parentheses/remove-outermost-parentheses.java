class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            
            if(s.charAt(i) == '('){
                if(!stack.isEmpty()){
                    ans.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}