class Solution {
    public int helper(int[] nums,int k){
        int right=0;
        int left = 0;
        int n = nums.length;
        int len = 0;
        int odd = 0;
        while(right<n){
            int curr = nums[right];
            if(curr%2!=0){
                odd++;
            }
            while(odd>k){
                int currleft = nums[left];
                if(currleft%2!=0){
                    odd--;
                }
                left++;
            }
            len+=(right-left+1);
            right++;
        }
        return len;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);       
    }
}