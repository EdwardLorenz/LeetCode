// two end
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet();
        
        for(String word : wordList){
            wordSet.add(word);
        }
        
        if(!wordSet.contains(endWord)) return 0;
        
        Set<String> start = new HashSet();
        Set<String> end = new HashSet();
        
        Set<String> visited = new HashSet();
        
        start.add(beginWord);
        end.add(endWord);
        
        visited.add(beginWord);
        visited.add(endWord);
        
        int distance = 1;
        
        while(!start.isEmpty() && !end.isEmpty()){
            
            // swap start and end set
            Set<String> swapTmp = start;
            start = end;
            end = swapTmp;

            
            // BFS
            Set<String> tmp = new HashSet();
            for(String word : start){
                
                 System.out.println("curWord " + word);
                 for(int i = 0; i < word.length(); i ++){
                    for(int j = 0; j < 26 ;j ++){
                        
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i,(char)('a' + j));
                        String newWord = sb.toString();
                        
                        if(end.contains(newWord)){
                            System.out.println("contains " + newWord);
                            return distance + 1;
                        }
                        
                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            System.out.println(newWord);
                            tmp.add(newWord);
                            visited.add(newWord);
                        }
                        
                    }
                }
            }
            start = tmp;
            distance ++;
        }
        return 0;
    }

}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))return 1;
        
        int len = beginWord.length();
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        Queue<String> curLevel = new LinkedList<>();
        
        int step = 1;
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        Set<String> wordSet = new HashSet<>();
        for(String str : wordList){
            wordSet.add(str);
        }
        
        while(!queue.isEmpty()){
            
            //curLevel = new LinkedList(queue);
            //queue.clear();
 
            step ++;// level up!
            
            // find all words with 1 distance from current word
            //for(String curStr : curLevel){
            curLevel = new LinkedList<>();
            while(!queue.isEmpty()){
                String curStr = queue.poll();
                for(int i = 0; i < len; i ++){
                    
                    for(int j = 0; j < 26; j ++){
                        char possibleLetter = (char)('a' + j);
                         String newCur = curStr.substring(0,i) + possibleLetter + curStr.substring(i + 1,len);
                         if(!visited.contains(newCur) && wordSet.contains(newCur)){// find one with 1 distance
                            if(newCur.equals(endWord)) return step;
                            //System.out.println(newCur + " " + step);
                            curLevel.offer(newCur);
                            visited.add(newCur);
                    }
                        
                    }
                    
                }
            }
            queue = curLevel;
            


        }
        
        return 0;
    }
    
}