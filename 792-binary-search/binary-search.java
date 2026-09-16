class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int n = nums.length-1;
        while(s<=n){
            int mid = s+(n-s)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                s=mid+1;
            }
            else{
                n = mid-1;
            }
        }
        return -1;
    }
}