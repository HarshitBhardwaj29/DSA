class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // this is for when window size increase than k we remove last index from the window 
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            } 
            // it is just to make max deque we remove the small elements from the queue
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            /// when index is greater than k-1 means it always form a window for we take max element as using deque in it 
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
