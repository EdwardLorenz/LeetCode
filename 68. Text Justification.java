class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList();
        
        int lineCnt = 0;// char cnt in current line; 
        List<String> lineList = new LinkedList();// words in current line
        
        
        for(String word : words){
            lineCnt += word.length();
            
            if(lineCnt <= maxWidth){
                lineList.add(word);
                lineCnt++; // Add a space
            }else{// line break
                
                // generate a line
                result.add(lineGenerator(lineList,maxWidth,lineCnt - word.length()));
                
                // clear lineList, add current word in
                lineList.clear();
                lineList.add(word);
                
                // reset line cnt
                lineCnt = word.length() + 1;
            } 
        }
        
        // last line
        if(!lineList.isEmpty()) result.add(generateLastLine(lineList,maxWidth, lineCnt));
        
        return result;
        
    }
    
    private String lineGenerator( List<String> lineList, int maxWidth, int lineCnt){
        
        int charCnt = lineCnt - lineList.size();
        
        int spaces = maxWidth - charCnt;
        
        int width = lineList.size() == 1 ? spaces: spaces / (lineList.size() - 1);

        char[] padding = new char[width];
        Arrays.fill(padding,' ');
        
        int remainder = lineList.size() == 1 ? 0: spaces % (lineList.size() - 1);
        
        StringBuilder sb = new StringBuilder();
        for(String word : lineList){
            sb.append(word);
            
            // add spaces
            sb.append(padding);

            // add remainder
            if(remainder-- > 0){
                sb.append(" ");
            }
            
        }
        return sb.toString().substring(0,maxWidth);
    }
    
    private String generateLastLine(List<String> lineList, int maxWidth, int lineCnt){
      
         StringBuilder sb = new StringBuilder();
        for(String word : lineList){
            sb.append(word);
            sb.append(" ");
        }
        
        if(sb.length() >= maxWidth) return sb.toString().substring(0,maxWidth);
        else{
             char[] padding = new char[maxWidth - sb.length()];
             Arrays.fill(padding,' ');
            sb.append(padding);
            return sb.toString();
        }
        
        
        
    }
}