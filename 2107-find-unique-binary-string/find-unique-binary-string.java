class Solution {
    String ans = "";
    public void helper(int n, String s, HashSet<String> set, int i){
        if(i == n){
            if(!set.contains(s) && ans.equals("")){
                ans = s;
            }
            return;
        }
        helper(n, s + "0", set, i + 1);
        helper(n, s + "1", set, i + 1);
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String num : nums){
            set.add(num);
        }
        helper(nums.length, "", set, 0);
        return ans;
    }
}