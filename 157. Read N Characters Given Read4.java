/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        int ptr = 0;
        char[] buff = new char[4];
        int buffCnt = 0;
        
        while(ptr < n){
            
            // read in
            buffCnt = read4(buff);
                   
            int buffPtr = 0;
            while(ptr < n && buffPtr < buffCnt){
                 buf[ptr ++] = buff[buffPtr++];
            }

            if(buffCnt < 4) break;
            
        }
        return ptr;
    }
}