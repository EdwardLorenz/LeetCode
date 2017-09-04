class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i = 0 ; ; i ++){// index for haystack
            for(int j = 0; ; j ++){// offset
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
        
    }
}