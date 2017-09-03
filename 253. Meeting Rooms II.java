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
    public int minMeetingRooms(Interval[] intervals) {
     
        int rooms = 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i ++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        /*
        For every start meeting: 
        
        if there is no meeting over, room ++
        
        else use the room of the finished meeting
        */
        for(int i = 0, endItr = 0; i < intervals.length; i ++){
            
            if(start[i] < end[endItr]){// must open a new room for this meeting
                rooms ++;
            }else{//use the room of the finished meeting
                endItr++;
            }
        }
        return rooms;
        
    }
}


// use a heap

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
    public int minMeetingRooms(Interval[] intervals) {
        
        if(intervals == null || intervals.length == 0){
            return 0;
        } 
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){return a.start - b.start;}
        });
        
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){return a.end - b.end;}
        });
        
        heap.offer(intervals[0]);
        
        for(int i = 1 ; i < intervals.length; i ++){
            Interval earliestEnd = heap.poll();
            
            if(intervals[i].start >= earliestEnd.end ){// combine
                earliestEnd.end = intervals[i].end;
            }else{// new room
                heap.offer(intervals[i]);
            }
            
            // put back
            heap.offer(earliestEnd);
        }
        return heap.size();
            
    }
}