import java.io.*;
import java.security.MessageDigest;

public class Solution {
    
    public static byte[] encryptByMd5(String str){
        
        byte[] theMD5digest = null;
        
        try{
            
            byte[] bytesOfMessage = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            theMD5digest = messageDigest.digest(bytesOfMessage);
        
        }catch(Exception exception){
            System.out.println(exception);
        }
        
        return theMD5digest;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
         String str = br.readLine();
         
         byte[] theMD5digest = encryptByMd5(str);
         
         for (byte b : theMD5digest) {
            System.out.format("%02x", b);
        }
         
      } catch (IOException iOException) {
         System.out.println(iOException);
      }
    }
}
