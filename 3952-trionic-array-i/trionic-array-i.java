class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<=3)return false;
        boolean p = false;
        boolean q = false;
         if(nums[0]>nums[1])return false;
        for(int i=1;i<n;i++){
            if (nums[i] == nums[i - 1]) return false;
            if(nums[i-1]>nums[i] && !p && !q){
                p=true;
            }
            else if(q==false && p==true && nums[i]>nums[i-1]){
                q=true;
            }
            else if(q==true && p==true){
                if(nums[i]<nums[i-1]){
                    return false;
                }
            }
        }
        return (p&&q);
    }
}