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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new LinkedList();
        
        int i = 0;
        // put in all intervals before newInteval
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i++));
        }
        
        // merge
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            int start = Math.min(newInterval.start,intervals.get(i).start);
            int end = Math.max(newInterval.end,intervals.get(i).end);
            newInterval = new Interval(start,end);
            i++;
        }
        
        res.add(newInterval);
        
        // put in all intervals after newInterval
        while(i < intervals.size()){
            res.add(intervals.get(i++));
        }
        return res;
        
    }
}