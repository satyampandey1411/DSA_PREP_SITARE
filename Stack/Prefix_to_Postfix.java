class Solution {
    static String preToPost(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i=s.length()-1; i>=0; i--){
            
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            } else{
                String left = st.pop();
                String right = st.pop();
                String exp = left + right + Character.toString(ch);
                st.push(exp);
            }
        }
        return st.pop();
        
    }
}
