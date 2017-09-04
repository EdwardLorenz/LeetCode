class Solution {
    /*
    From left to right, add building remove building,
    keep track of max height, whener it changes, write to result.
    */
    public List<int[]> getSkyline(int[][] buildings) {
        
        List<int[]> res = new LinkedList();
        
        if(buildings == null || buildings.length == 0) return res;
        
        PriorityQueue<int[]> heap = new PriorityQueue(buildings.length * 2, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        
        for(int[] building : buildings){
            heap.offer(new int[] {building[0],building[2]});
            heap.offer(new int[] {building[1],- building[2]});
        }
        
        PriorityQueue<Integer> heightQueue = new PriorityQueue(buildings.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){// descending order
                return b - a;
            }
        });
        
        int lastMax = 0;
        
        while(!heap.isEmpty()){
            int[] cur = heap.poll();// 0: pos, 1 : height
            int pos = cur[0], height = cur[1];
            
            if(height < 0){// end of building
                heightQueue.remove(-height);
               
            }else{
                 heightQueue.offer(height);
            }
            
            int maxHeight = heightQueue.isEmpty() ? 0:heightQueue.peek();// get highest building
            
            if(maxHeight !=  lastMax){
                res.add(new int[] {pos,maxHeight});
                lastMax = maxHeight;
            }
            
 
            
        }
        
        
        return res;
    }
}