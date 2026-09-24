class Solution {
    public int sum(int n){
        while(n>0){
            return n%10+sum(n/10);
        }
        return 0;
    }
    public int smallestIndex(int[] nums) {
        int c=0;
        for(int i:nums){
            if(sum(i)==c)return c;
            c++;
        }
        return -1;
    }
}