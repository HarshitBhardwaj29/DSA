class Solution {
    public int maxPalindromes(String s, int k) {
        int cnt=0;
        int n= s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)&& j-i+1>=k){
                    cnt++;
                    i=j;
                    break;
                }
                if(j-i+1>k) break;
            }
        }
        return cnt;
        
    }
    boolean isPalindrome(String s,int i,int j){
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}