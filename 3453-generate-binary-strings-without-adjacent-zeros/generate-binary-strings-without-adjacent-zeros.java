class Solution {
    public void helper(char last, int n, String ans, List<String> list) {
        if (ans.length() == n) {
            list.add(ans);
            return;
        }
        if (last == '0') {
            helper('1', n, ans + '1', list);
        } else {
            helper('0', n, ans + '0', list);
            helper('1', n, ans + '1', list);
        }
    }

    public List<String> validStrings(int n) {

        List<String> list = new ArrayList<>();
        helper('0', n, "0", list);
        helper('1', n, "1", list);
        return list;
    }
}