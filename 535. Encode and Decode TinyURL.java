public class Codec {

    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Map<String,String> long2short = new HashMap();
    Map<String,String> short2long = new HashMap();
    int shortLength = 6;
    Random ran = new Random();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        if(long2short.containsKey(longUrl)) return long2short.get(longUrl);
        
        StringBuilder sb = new StringBuilder();
        String res = "";
        // generate short randomly
        do{
            for(int i = 0; i < shortLength; i ++){
            sb.append(charSet.charAt(ran.nextInt(charSet.length())));
            }
            res = sb.toString();
        }while(short2long.containsKey(res));
        
        System.out.println(res);
        
        long2short.put(longUrl,res);
        short2long.put(res,longUrl);
        
        return res;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2long.get(shortUrl);
    }
    
    /*
        use index as coded short URL:
        dis: 1. can't reuse , 2. people will know how many  url we have
    */
    public class Codec2 {
    List<String> urls = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index<urls.size())?urls.get(index):"";
    }
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));