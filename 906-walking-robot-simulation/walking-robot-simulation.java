import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashSet<String> set = new HashSet<>();
        for (int[] c : obstacles) {
            set.add(c[0] + "," + c[1]);
        }

        int x = 0, y = 0;
        String dir = "north";
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                if (dir.equals("north")) dir = "east";
                else if (dir.equals("east")) dir = "south";
                else if (dir.equals("south")) dir = "west";
                else if (dir.equals("west")) dir = "north";
            }

            else if (cmd == -2) {
                if (dir.equals("north")) dir = "west";
                else if (dir.equals("west")) dir = "south";
                else if (dir.equals("south")) dir = "east";
                else if (dir.equals("east")) dir = "north";
            }
            else {
                for (int i = 0; i < cmd; i++) {

                    int nx = x, ny = y;

                    if (dir.equals("north")) ny++;
                    else if (dir.equals("south")) ny--;
                    else if (dir.equals("east")) nx++;
                    else if (dir.equals("west")) nx--;

                    if (set.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}