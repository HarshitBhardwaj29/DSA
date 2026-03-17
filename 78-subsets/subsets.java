class Solution {
    public void helper(int i,int[] nums,List<Integer> list,List<List<Integer>> result){
        if(i==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(i+1,nums,list,result);
        list.remove(list.size()-1);
        helper(i+1,nums,list,result);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(0,nums,list,result);
        return result;
    }
}