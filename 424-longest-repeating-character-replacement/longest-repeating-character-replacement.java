class Solution {
    public int characterReplacement(String s, int k) {
        int left =0;
        int right=0;
        int maxlen = 0;
        int n = s.length();
        int maxfreq = 0;
        int[] freq = new int[26];
        while(right<n){
            char curr = s.charAt(right);
            freq[curr-'A']++;
            maxfreq = Math.max(maxfreq,freq[curr-'A']);
            while((right-left+1)-maxfreq>k){
                char currleft = s.charAt(left);
                freq[currleft-'A']--;
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}