class AutocompleteSystem {

    StringBuilder newSentence = new StringBuilder();
    class TreeNode{
        
        Sentence sentence = new Sentence();
        TreeNode[] children = new TreeNode[27];// "a"~"z" and " "
 
    }
    
    class Sentence{
        String content = "";
        int freq = 0;
    }
    
    TreeNode root = new TreeNode();
    TreeNode cur = root;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        
        // build dictionary tree
        for(int i = 0 ; i < sentences.length; i ++){
            buildTree(sentences[i],times[i]);
        }
    }
    
    private void buildTree(String sentence, int time){
        
        TreeNode node = root;
        for(char c : sentence.toCharArray()){
            int idx = c == ' ' ? 26 : c - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TreeNode();
            }
            
             node = node.children[idx];
        }
        
        node.sentence.content = sentence;
        node.sentence.freq += time;
        
    }
    
    private  void find(TreeNode node, PriorityQueue<Sentence> queue){//find all sentences have node as root
        
        if(node.sentence.content != "") {
            queue.offer(node.sentence);
        }
        
        for(int i = 0; i < 27 ; i++){
            if(node.children[i] != null) find(node.children[i],queue);
        }
        
    }
    
    public List<String> input(char c) {
     
        PriorityQueue<Sentence> queue = new PriorityQueue(3, new Comparator<Sentence>(){
            public int compare(Sentence s1, Sentence s2){
                
                if( s2.freq == s1.freq) return s1.content.compareTo(s2.content);// ascending order in ASCII
                return s2.freq - s1.freq;// descending order in freq
            }
        });
        
        int idx = c == ' ' ? 26 : c - 'a';
        if(c != '#'){
            newSentence.append(c);
            cur = cur == null ?  null : cur.children[idx];
            
            if(cur != null){
                find(cur,queue);
            }else{
                return new LinkedList();
            }
            
            
        }else{
            cur = root;
            buildTree(newSentence.toString(),1);// Add a sentence to list
            newSentence= new StringBuilder();
        }
        
        List<String> res = new LinkedList();
        
        while(!queue.isEmpty() && res.size() < 3){
            Sentence s = queue.poll();
            res.add(s.content);
        }
        queue.clear();
        return res;
        
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */