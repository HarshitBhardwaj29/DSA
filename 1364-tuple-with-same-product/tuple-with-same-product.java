class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pro = nums[i] * nums[j];
                map.put(pro, map.getOrDefault(pro, 0) + 1);
            }
        }

        int count = 0;
        for (int val : map.values()) {
            if (val >= 2) {
                count += (val * (val - 1) / 2) * 8;
            }
        }

        return count;
    }
}
