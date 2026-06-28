class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        if(arr[0]!=1){
            ans1 = arr.length;
        }
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])<=1) continue;
            else{
                arr[i]=arr[i-1]+1;
            }
        }
        ans2 = arr[arr.length-1];
        return Math.min(ans1,ans2);
    }
}