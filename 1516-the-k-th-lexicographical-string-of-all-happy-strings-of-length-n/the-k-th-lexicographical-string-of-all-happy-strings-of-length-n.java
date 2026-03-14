class Solution {
    public void helper(int prev, char[] arr, int n, StringBuilder sb, ArrayList<String> list) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (i == prev) continue;
            sb.append(arr[i]);
            helper(i, arr, n, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        char[] arr = {'a','b','c'};
        ArrayList<String> list = new ArrayList<>();
        helper(-1, arr, n, new StringBuilder(), list);
        if (k > list.size()) return "";
        return list.get(k - 1);
    }
}