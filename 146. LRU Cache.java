class LRUCache {
    
    class Node{
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int x, int k){val = x; key = k;}
    }
    
    int cap;
    Map<Integer,Node> map = new HashMap();
    Node dummyHead = new Node(0,0);

    public LRUCache(int capacity) {
        cap = capacity;
        dummyHead.next = dummyHead;
        dummyHead.pre = dummyHead;
    }
    /*
    1. LRU: remove + insert
    */
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // manage cache content
        Node node =  map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    /*
    1. constains : remove
    2. add : insert
    3. map : put
    4. evict
    */
    public void put(int key, int value) {
        // manage cache content
        if(map.containsKey(key)){
            remove(map.get(key));// remove old
        }
        
        Node node =  new Node(value,key);
        insert(node);
        
        // add to map
        map.put(key,node);
        
         // evict
        if(map.size() > cap){
            map.remove(dummyHead.pre.key); 
            remove(dummyHead.pre);
        }

    }
    
    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    // Add to head
    private void insert(Node node){
        
        node.next = dummyHead.next;
        dummyHead.next = node;
        
        node.next.pre = node;
        node.pre = dummyHead;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */