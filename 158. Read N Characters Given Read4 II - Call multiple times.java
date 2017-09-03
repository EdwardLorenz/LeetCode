/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buff = new char[4];
    int buffCnt = 0;// valid 
    int buffPtr = 0;// index of char to read
    
    public int read(char[] buf, int n) {
        
        int ptr = 0;// index of dest buf
        
        while(ptr < n){
            // read in new
            if(buffPtr == 0){
                buffCnt = read4(buff);
            }
            
            if(buffCnt == 0) break;
            
            // copy
            while(ptr < n && buffPtr < buffCnt){
                buf[ptr++] = buff[buffPtr++];
            }
            
            if(buffPtr >= buffCnt){
                buffPtr = 0;
            }

        }
        
        return ptr;
        
    }
}