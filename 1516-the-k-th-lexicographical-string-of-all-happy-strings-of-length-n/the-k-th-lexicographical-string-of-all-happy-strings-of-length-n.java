class Solution {

    public void helper(int prev, char[] arr, int n, String s, ArrayList<String> list) {
        if (s.length() == n) {
            list.add(s);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (i == prev) continue; 
            helper(i, arr, n, s + arr[i], list);
        }
    }

    public String getHappyString(int n, int k) {
        char[] arr = {'a','b','c'};
        ArrayList<String> list = new ArrayList<>();
        helper(-1, arr, n, "", list);
        if (k > list.size()) return "";
        return list.get(k-1);
    }
}