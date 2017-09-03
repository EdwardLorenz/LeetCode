/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
     
        int candidate = 0;
        
        // find candidate
        /*
        
        A. The problem qurantee that there is only one person knows nobody
        
        B. When this stops, 
        
        1. it is guranteed that people before i is no celebrity,because he knows someone else
        2. it is guranteed that people after i is no celebrity, because it doesn't know him
        
        
        */
        for(int i = 1; i < n; i ++){
            if(knows(candidate,i)) candidate = i;
        }
        
        // Check the candidate
        for(int i = 0; i < n; i ++){
            
            if(i != candidate && ( knows(candidate,i) || !knows(i,candidate)  )) return -1;
            
        }
        
        return candidate;
        
    }
}