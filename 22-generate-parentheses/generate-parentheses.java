class Solution {
    public void helper(int n,int left,int right,String s,List<String> list){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(left<n){
            helper(n,left+1,right,s+'(',list);
        }
        if(right<left){
            helper(n,left,right+1,s+')',list);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n,0,0,"",list);
        return list;
    }
}