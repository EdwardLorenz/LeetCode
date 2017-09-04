/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        
        if( intervals == null || intervals.length == 0 ) return true;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i ++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        for(int i = 0; i < intervals.length - 1; i ++){
            
            if(starts[i+1] < ends[i]){
                return false;
            }
        }
        return true;
        
    }
}