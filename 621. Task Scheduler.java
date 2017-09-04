public class Solution {
    /*
        n(logn)
    */
    public int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
    
    /*
        
    */

   
    public int leastInterval2(char[] tasks, int n) {
        int[] count = new int[26];
        int[] nextA = new int[26];
        int m = 0;
        for(char c: tasks){
            count[c - 'A']++;
            m++;
        }
        n++;
        int cur = 0;
        while(m > 0){
            int max = -1;
            for(int i = 0; i < 26; i++){
                if(count[i] > 0 && nextA[i] <= cur && (max < 0 || count[i] > count[max]))
                    max = i;
            }
            cur++;
            if(max != -1){
                nextA[max] += n;
                count[max]--;
                m--;
            }
            //System.out.println(max);
            
        }
        return cur;
    }

}