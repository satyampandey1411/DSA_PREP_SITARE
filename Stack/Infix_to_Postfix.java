class Solution {
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
            
            else if (c == '(') {
                st.push(c);
            }
            
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop(); 
            }

            else {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(c)) {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }
    
    private static int precedence(char c){
        switch(c) {
            case '+' : case '-':
                return 1;
            case '*' : case '/':
                return 2;
            case '^' :
                return 3;
        }
        return -1;
    }
}
