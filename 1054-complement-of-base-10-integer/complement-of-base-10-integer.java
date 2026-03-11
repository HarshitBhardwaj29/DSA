class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        String ans ="";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            ans += (c == '0') ? '1' : '0';
        }
        return Integer.parseInt(ans,2);
    }
}