class Solution {
    public boolean hasAllCodes(String s, int k) {
    int n = s.length();
    if (n < k) return false;

    int total = 1 << k;
    int[] map = new int[total];
    int left = 0;
    StringBuilder sb = new StringBuilder();

    for (int right = 0; right < n; right++) {
        char j = s.charAt(right);
        sb.append(j);
        if (right - left + 1 == k) {
            int idx = Integer.parseInt(sb.toString(), 2);
            map[idx]++;
            sb.deleteCharAt(0);
            left++;
        }
    }
    for (int i = 0; i < map.length; i++) {
        if (map[i] == 0) return false;
    }

    return true;
}
}