class Solution {
public:
    long long gcd(long long a, long long b) {
        while (b != 0) {
            long long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long long gcdSum(vector<int>& nums) {
        long long sum = 0;
        int maxi = INT_MIN;
        vector<int> prefixgcd(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            if (maxi < nums[i]) {
                maxi = nums[i];
            }
            prefixgcd[i] = gcd(maxi, nums[i]);
        }
        sort(prefixgcd.begin(), prefixgcd.end());
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            long long ans = gcd(prefixgcd[i], prefixgcd[j]);
            sum += ans;
            i++;
            j--;
        }
        return sum;
    }
};