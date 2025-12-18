class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            } else if (st.isEmpty() || (ch == ']' && st.pop() != '[') || (ch == '}' && st.pop() != '{')
                    || (ch == ')' && st.pop() != '(')) {
                    return false;
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
