class Solution {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;
        int n = colors.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                else if(colors[i]!=colors[j]){
                    max = Math.max(max,Math.abs(i-j));
                }
            }
        }
        return max;
    }
}