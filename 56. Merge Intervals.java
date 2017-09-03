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
    public List<Interval> merge(List<Interval> intervals) {
        
        List<Interval> result = new LinkedList<>();
        
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        
        for(int i = 0; i < intervals.size(); i ++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        for(int i = 0, curStart = 0; i < intervals.size(); i ++){
            
            if(i == intervals.size() - 1 || starts[i + 1] > ends[i]){
                
                result.add(new Interval(starts[curStart],ends[i]));
                
                curStart = i + 1;
            }
            
        }
        return result;
    }
}