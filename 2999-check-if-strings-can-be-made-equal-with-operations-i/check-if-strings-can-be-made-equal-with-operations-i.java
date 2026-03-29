class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (swap(s1, 0, 2).equals(s2)) return true;
        if (swap(s1, 1, 3).equals(s2)) return true;
        String temp = swap(s1, 0, 2);
        temp = swap(temp, 1, 3);
        if (temp.equals(s2)) return true;
        return false;
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return new String(arr);
    }
}