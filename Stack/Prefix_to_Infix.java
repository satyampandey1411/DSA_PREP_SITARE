class Solution {
    static String postToInfix(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            } else{
                String right = st.pop();
                String left = st.pop();
                String exp = "(" + left + Character.toString(ch) + right + ")";
                st.push(exp);
            }
        }
        return st.pop();
        
    }
}
