class Solution {
    public double angleClock(int hour, int minutes) {
        double hrangle = ((hour%12) * 30) + (0.5 * minutes);
        double minangle = (minutes*6);
        double ans = Math.abs(minangle-hrangle);
        return Math.min(ans,360-ans); 
    }
}