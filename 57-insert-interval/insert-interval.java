class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int s = newInterval[0];
        int e = newInterval[1];

        ArrayList<int[]> list = new ArrayList<>();

        for (int[] arr : intervals) {
            if (arr[1] < s) {
                list.add(arr);
            }
            else if (arr[0] <= e) {
                s = Math.min(s, arr[0]);
                e = Math.max(e, arr[1]);
            }
            else {
                list.add(new int[]{s, e});

                s = arr[0];
                e = arr[1];
            }
        }

        list.add(new int[]{s, e});

        return list.toArray(new int[list.size()][]);
    }
}