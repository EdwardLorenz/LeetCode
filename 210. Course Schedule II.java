class Solution {
    
    Map<Integer, Integer> cntMap = new HashMap();// <course, pre_cnt>
    Map<Integer, List<Integer>> courseMap = new HashMap();// <preCourse, courseList>
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] result = new int[numCourses];
        int index = 0;
        
        if(numCourses == 0) return result;
        
        if(prerequisites.length == 0){
            for(int i = 0; i < numCourses; i ++){
                result[i] = i;
            }
            return result;
        }
        
        initiate(prerequisites);
        
        Queue<Integer> queue = new LinkedList();
        
         // Initiate queue by finding courses with no prerequisites
        for(int i = 0; i < numCourses; i ++){
            if(!cntMap.containsKey(i)){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int course = queue.poll();
            result[index ++] = course;
            
            // remove pre-requisites
            List<Integer> list = courseMap.getOrDefault(course, new LinkedList());
            
            for(Integer i : list){
                int cnt = cntMap.get(i);
                cnt --;
                if(cnt == 0){// find one course with no prerequisites
                    cntMap.remove(i);
                    queue.offer(i);// add to the queue
                }else{
                    cntMap.put(i,cnt);
                }
            }     
        }
        
        if(index < numCourses - 1) return new int[0];
        
       return result;
        
    }
    
    
    private void initiate(int[][] prerequisites){
        
        for(int i = 0 ; i < prerequisites.length; i ++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            int cnt = cntMap.getOrDefault(course,0);
            cnt ++;
            cntMap.put(course,cnt);
            
            List<Integer> list = courseMap.getOrDefault(pre, new LinkedList());
            list.add(course);
            courseMap.put(pre,list);
            
        }
        
    }
}