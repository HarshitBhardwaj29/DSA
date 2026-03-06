class Solution {
    public boolean checkOnesSegment(String s) {
        int prev=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(prev)=='0' && s.charAt(i)=='1'){
                return false;
            }
            prev=i;
        }
        return true;
    }
}