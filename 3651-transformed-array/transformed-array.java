class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int z=0;
        int[] arr = new int[n];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)arr[z]=nums[i];
            else if(nums[i]<0){
                int k = (i + nums[i]) % n;
                if (k < 0) k += n;
                arr[z] = nums[k];
            }
            else {
                int k = (i+Math.abs(nums[i]))%n;
                arr[z]= nums[k];
            }
            z++;
        }
        return arr;
    }
}