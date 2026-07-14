class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        long long ans = 0;
        int check = x;
        while (x > 0) {
            int rem = x % 10;
            ans = ans * 10 + rem;
            x /= 10;
        }
        return ans == check;
    }
};