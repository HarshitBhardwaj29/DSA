class Solution {
public:
    int gcd(int a, int b) {
        while (b) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    int gcdOfOddEvenSums(int n) {
        int odd = 1;
        int even = 2;
        int sumo = 0;
        int sume = 0;
        while (n--) {
            sumo += odd;
            sume += even;
            odd += 2;
            even += 2;
        }
        return gcd(sumo, sume);
    }
};