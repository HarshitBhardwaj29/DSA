class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(curr.toString());
                curr = new StringBuilder();
            }
            else if (s.charAt(i) == ')') {
                curr.reverse();
                String previous = st.pop();
                curr = new StringBuilder(previous + curr);
            }
            else {
                curr.append(s.charAt(i));
            }
        }
        return curr.toString();
    }
}