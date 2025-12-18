class Solution {
    static String preToInfix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

    
            if (Character.isLetterOrDigit(ch)) {
                st.push(Character.toString(ch));
            } 
       
            else {
                String left = st.pop();
                String right = st.pop();
                String expr = "(" + left + ch + right + ")";
                st.push(expr);
            }
        }

        return st.pop();
    }
}
