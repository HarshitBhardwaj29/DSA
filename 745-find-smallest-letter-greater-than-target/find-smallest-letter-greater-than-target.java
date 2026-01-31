class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] arr = new int[26];
        int a = target-'a';
        for(char ck:letters){
            arr[ck-'a']++;
        }
        char ans =' '; 
        for(int i=a+1;i<26;i++){
            if(arr[i]>=1){
                char ch = (char) (i + 'a');
                return ch;
            }
        }
        return letters[0];
    }
}