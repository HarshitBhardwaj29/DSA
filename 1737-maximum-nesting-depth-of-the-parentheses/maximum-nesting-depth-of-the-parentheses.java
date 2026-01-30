class Solution {
    public int maxDepth(String s) {
        int k=0;
        int max=0;
        for(char c :s.toCharArray()){
            if(c=='('){
                k++;
                max = Math.max(max,k);
            }
            else if(c==')'){
                k--;
            }
        }
        return max;
    }
}