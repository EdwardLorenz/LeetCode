class Solution {
    Stack<Integer> stack = new Stack();
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        int prevTime = 0;
        
        for(String log : logs){
            String[] cols = log.split(":");// 0 : id, 1 : type, 2 : ts
            
            if(!stack.isEmpty()) result[stack.peek()] += Integer.valueOf(cols[2]) - prevTime;
            
            prevTime = Integer.valueOf(cols[2]);
            
            if(cols[1].equals("start")){
                stack.push( Integer.valueOf(cols[0]));
            }else{
                result[stack.pop()] ++;
                prevTime ++;
            }    
        }
        return result;
    }
}