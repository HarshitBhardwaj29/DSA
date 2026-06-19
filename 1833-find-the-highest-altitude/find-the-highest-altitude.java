class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int h = 0;
        for(int i=0;i<gain.length;i++){
            max = Math.max(max,h);
            h = h+gain[i];
        }
        max=Math.max(max,h);
        return max;
    }
}