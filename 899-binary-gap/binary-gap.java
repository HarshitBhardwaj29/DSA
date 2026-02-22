class Solution {
    public int binaryGap(int n) {
        int prev = -1;
        int max = 0;
        int i = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    if (prev != -1)
                        max = Math.max(max, i - prev);
                        prev = i;
                }
            i++;
            n >>= 1;
        }
    return max;
    }
}