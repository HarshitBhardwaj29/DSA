class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}