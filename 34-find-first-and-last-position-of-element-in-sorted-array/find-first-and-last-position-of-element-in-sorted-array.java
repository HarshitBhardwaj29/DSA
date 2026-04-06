class Solution {
    public int last(int[] nums, int t, boolean flag) {
        int s = 0, e = nums.length - 1, ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == t) {
                ans = mid;
                if (flag) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else if (nums[mid] < t) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{ last(nums, target, false), last(nums, target, true) };
    }
}
