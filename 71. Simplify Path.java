class Solution {
    // dir name - >push
    // .. - > pop
    //. -> nothing
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack();
        // get names
        String[] dirs = path.split("/");
        
        for(String dir : dirs){
            
            if(dir.length() == 0) continue;
            
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(dir.equals(".")){// current dir
                
            }else{//dir name
                 stack.push(dir);
            }
        }
        
        if(stack.isEmpty()) return "/";
        StringBuilder result = new StringBuilder();
        
        // generate path
        for(String str : stack){
            result.append("/");
            result.append(str);
        }
        
        return result.toString();
        
        
    }
}