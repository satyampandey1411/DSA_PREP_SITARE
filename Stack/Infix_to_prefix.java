import java.util.*;

class Solution {
    public String infixToPrefix(String s) {

        StringBuilder rev = new StringBuilder(s).reverse();
        StringBuilder swapped = new StringBuilder();

        for (int i = 0; i < rev.length(); i++) {
            char ch = rev.charAt(i);
            if (ch == '(') swapped.append(')');
            else if (ch == ')') swapped.append('(');
            else swapped.append(ch);
        }


        String postfix = infixToPostfix(swapped.toString());


        return new StringBuilder(postfix).reverse().toString();
    }

    private String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            }
            else { 
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    private int precedence(char ch) {
        switch (ch) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
