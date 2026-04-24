class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        for(char c :moves.toCharArray()){
            if(c=='L'){
                l++;
            }
            else if(c=='R'){
                r++;
            }
        }
        int min = Math.min(l,r);
        return moves.length()-2*min;
    }
}