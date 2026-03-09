class Solution {
    public void moveZeroes(int[] nums) {
        int l =0;
        int r=0;
        while(l<nums.length){
            if(nums[l]!=0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            }
            else{
                l++;
            }
        }
    }
}