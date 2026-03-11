class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        int c=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int sum = nums3[i]+nums4[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){  
                int sum=nums1[i]+nums2[j];
                int diff = 0-sum;
                if(map.containsKey(diff)){
                    c+=map.get(diff);
                }            
            }
        }
        return c;
    }
}