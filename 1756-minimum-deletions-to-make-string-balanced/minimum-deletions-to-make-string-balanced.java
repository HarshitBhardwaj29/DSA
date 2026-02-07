class Solution {
    public int minimumDeletions(String s) {
        int n = s.length()-1;
        Stack<Character> st= new Stack<>();
        int k=0;
        for(int i=n;i>=0;i--){
            if(!st.isEmpty() && st.peek()=='a' && s.charAt(i)=='b'){
                k++;
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return k;
    }
}