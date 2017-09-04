class RandomizedSet {
    
    List<Integer> values = new ArrayList();
    Map<Integer,Integer> locMap = new HashMap();
    Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locMap.containsKey(val)) return false;
        
        values.add(val);
        locMap.put(val,values.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!locMap.containsKey(val)) return false;
        
        int loc = locMap.get(val);
        if(loc < values.size() - 1){// if not the last one to delete, swap
            int last = values.get(values.size() - 1);
            values.set(loc,last);
            locMap.put(last,loc);
        }
        // delete
        locMap.remove(val);
        values.remove(values.size() - 1);

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */