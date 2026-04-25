class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (Math.abs(a) > stack.peek()) {
                    stack.pop();
                    continue;
                } else if (Math.abs(a) == stack.peek()) {
                    stack.pop();
                }
                a = 0;
            }
            if (a != 0) {
                stack.push(a);
            }
        }
        int[] arr = new int[stack.size()];
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] = stack.pop();
            }
        return arr;
    }
}