class Solution {
public:
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    int findGCD(vector<int>& nums) {
        int n = nums.size();

        int s = nums[0];
        int l = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < s) {
                s = nums[i];
            }
            if (nums[i] > l) {
                l = nums[i];
            }
        }
        return gcd(s, l);
    }
};